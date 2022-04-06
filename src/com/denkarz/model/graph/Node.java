package com.denkarz.model.graph;

public class Node {
    private Character name;
    private Boolean searchProperty;

    public Node() {
    }

    public Character getName() {
        return name;
    }

    public void setName(Character name) {
        this.name = name;
    }

    public Boolean getSearchProperty() {
        return searchProperty;
    }

    public void setSearchProperty(Boolean searchProperty) {
        this.searchProperty = searchProperty;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", searchProperty=" + searchProperty +
                '}';
    }
}
