package com.denkarz.model.graph;


public class Graph {
    private Node sourceNode;
    private Node targetNode;
    private Integer distance;

    public Graph() {
    }

    public Node getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public Node getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(Node targetNode) {
        this.targetNode = targetNode;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "sourceNode=" + sourceNode +
                ", targetNode=" + targetNode +
                ", distance=" + distance +
                '}';
    }
}
