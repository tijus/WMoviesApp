package com.example.waymovies;

public class Query {

    private static String query;

    public static final String API_KEY="71ab1b19293efe581c569c1c79d0f004";

    public static void setQuery(String input) {
        query = input;
    }

    public static String getQuery() {
        return query;
    }
}
