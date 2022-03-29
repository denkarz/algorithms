package com.denkarz.service.Graph;

import com.denkarz.model.GraphNode;

public interface GraphService {
    GraphNode generateGraph(int depth, int maxChildren);
    void updatePropertyUsingBFS(GraphNode graph, String nodeName, Boolean newProperty);
    void updatePropertyUsingDFS(GraphNode graph, String nodeName, Boolean newProperty);


}
