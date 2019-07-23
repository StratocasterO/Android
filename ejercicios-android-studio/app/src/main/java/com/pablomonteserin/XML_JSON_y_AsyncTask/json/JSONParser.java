package com.pablomonteserin.XML_JSON_y_AsyncTask.json;

import android.util.JsonReader;
import android.util.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by monty on 5/10/17.
 */

public class JSONParser {
    public List<Libro> readJsonStream(InputStream in) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
        try {
            return readMessagesArray(reader);
        } finally {
            reader.close();
        }
    }

    public List<Libro> readMessagesArray(JsonReader reader) throws IOException {
        List<Libro> messages = new ArrayList<Libro>();

        reader.beginArray();
        while (reader.hasNext()) {
            messages.add(readMessage(reader));
        }
        reader.endArray();
        return messages;
    }

    public Libro readMessage(JsonReader reader) throws IOException {
        long id = -1;
        String titulo = null;
        Autor autor = null;
        List<Double> geo = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("id")) {
                id = reader.nextLong();
            } else if (name.equals("titulo")) {
                titulo = reader.nextString();
            } else if (name.equals("geo") && reader.peek() != JsonToken.NULL) {
                geo = readDoublesArray(reader);
            } else if (name.equals("autor")) {
                autor = readAutor(reader);
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Libro(id, titulo, geo, autor);
    }

    public List<Double> readDoublesArray(JsonReader reader) throws IOException {
        List<Double> doubles = new ArrayList<Double>();

        reader.beginArray();
        while (reader.hasNext()) {
            doubles.add(reader.nextDouble());
        }
        reader.endArray();
        return doubles;
    }

    public Autor readAutor(JsonReader reader) throws IOException {
        String nombre = null;
        int seguidores = -1;

        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("nombre")) {
                nombre = reader.nextString();
            } else if (name.equals("seguidores")) {
                seguidores = reader.nextInt();
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return new Autor(nombre, seguidores);
    }

    public static class Libro {
        public final long id;
        public final String titulo;
        public final List<Double> geo;
        public final Autor autor;

        private Libro(long id, String titulo, List<Double> geo, Autor autor) {
            this.id = id;
            this.titulo = titulo;
            this.geo = geo;
            this.autor = autor;
        }
    }

    public static class Autor {
        public final String nombre;
        public final int seguidores;

        private Autor(String nombre, int seguidores) {
            this.nombre = nombre;
            this.seguidores = seguidores;
        }
    }
}
