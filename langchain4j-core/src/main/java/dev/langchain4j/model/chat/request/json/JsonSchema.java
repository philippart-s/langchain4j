package dev.langchain4j.model.chat.request.json;

import dev.langchain4j.Experimental;

import java.util.Objects;

import static dev.langchain4j.internal.Utils.quoted;

@Experimental
public class JsonSchema {

    private final String name;
    private final JsonObjectSchema schema;

    public JsonSchema(Builder builder) {
        this.name = builder.name;
        this.schema = builder.schema;
    }

    public String name() {
        return name;
    }

    public JsonObjectSchema schema() {
        return schema;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String name;
        private JsonObjectSchema schema;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder schema(JsonObjectSchema schema) {
            this.schema = schema;
            return this;
        }

        public JsonSchema build() {
            return new JsonSchema(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsonSchema that = (JsonSchema) o;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.schema, that.schema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, schema);
    }

    @Override
    public String toString() {
        return "JsonSchema {" +
                " name = " + quoted(name) +
                ", schema = " + schema +
                " }";
    }
}
