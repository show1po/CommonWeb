package com.xgene.common.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.xgene.common.dto.XgeneResponseResult;
import com.xgene.common.exception.ErrorStatusCode;

import java.io.IOException;

public class XgeneResponse {
    public class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringNullAdapter();
        }
    }

    public class StringNullAdapter extends TypeAdapter<String> {
        @Override
        public String read(JsonReader reader) throws IOException {
            // TODO Auto-generated method stub
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }

        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            // TODO Auto-generated method stub
            if (value == null) {
                writer.value("");
                return;
            }
            writer.value(value);
        }
    }

    Gson gson = new GsonBuilder().disableHtmlEscaping().registerTypeAdapterFactory(new NullStringToEmptyAdapterFactory()).create();

    protected <T> String success(T data) {
        return gson.toJson(XgeneResponseResult.success(data));
    }

    protected String failure(ErrorStatusCode statusCode,String message) {
        return gson.toJson(XgeneResponseResult.failure(statusCode,message));
    }
}
