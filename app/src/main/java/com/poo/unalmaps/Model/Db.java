package com.poo.unalmaps.Model;

import java.util.HashMap;
import java.util.List;

public class Db {
    private static List<String> names;
    private List<HashMap> edificios;

    public Db(List<String> names, List<HashMap> edificios) {
        this.names = names;
        this.edificios = edificios;
    }

    public static List<String> getNames() {
        return names;
    }

    public List<HashMap> getEdificios() {
        return edificios;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setEdificios(List<HashMap> edificios) {
        this.edificios = edificios;
    }
}
