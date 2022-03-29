package com.denkarz.model;

import java.util.List;

public class GraphNode {
    private String name;
    private Integer weightToParent;
    private Boolean searchProperty;
    List<GraphNode> children;

    public GraphNode() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeightToParent() {
        return weightToParent;
    }

    public void setWeightToParent(Integer weightToParent) {
        this.weightToParent = weightToParent;
    }

    public Boolean getSearchProperty() {
        return searchProperty;
    }

    public void setSearchProperty(Boolean searchProperty) {
        this.searchProperty = searchProperty;
    }

    public List<GraphNode> getChildren() {
        return children;
    }

    public void setChildren(List<GraphNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "GraphNode{" +
                "name='" + name + '\'' +
                ", weightToParent=" + weightToParent +
                ", searchProperty=" + searchProperty +
                ", children=" + children +
                '}';
    }
}
