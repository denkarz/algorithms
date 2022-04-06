package com.denkarz.service.Graph;

import com.denkarz.model.graph.Graph;
import com.denkarz.model.graph.Node;

import java.util.List;

public interface GraphService {
    List<Graph> generateGraph(int nodeCount);
    void updatePropertyUsingBFS(List<Graph> graph, Character nodeName, Boolean newProperty);
    void updatePropertyUsingDFS(List<Graph> graph, Character nodeName, Boolean newProperty);
    void updatePropertyUsingDjeikstra(List<Graph> graph, Character nodeName, Boolean newProperty);

}
