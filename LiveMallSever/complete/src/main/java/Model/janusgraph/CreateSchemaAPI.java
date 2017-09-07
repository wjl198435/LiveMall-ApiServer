package Model.janusgraph;

import Model.tinkerpop.register.user.schema;
import org.apache.tinkerpop.gremlin.process.traversal.Order;
import org.apache.tinkerpop.gremlin.structure.Direction;
import org.janusgraph.core.*;
import org.janusgraph.core.schema.JanusGraphManagement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by wjl198435 on 7/9/2017.
 */
public class CreateSchemaAPI {
    private static final Logger LOGGER = LoggerFactory.getLogger(schema.class);

    public static void makeVertexLabel(JanusGraph jGraph , String vertexLabel , Boolean partition ) {


        if (jGraph != null && !vertexLabel.isEmpty()) {
            JanusGraphManagement mgmt  = jGraph.openManagement();
            if (mgmt != null) {

                if (mgmt.getVertexLabel(vertexLabel) == null) {
                    LOGGER.info("makeVertexLabel :" + vertexLabel + "as not existing");

                    if (partition == true) {
                        VertexLabel label = mgmt.makeVertexLabel(vertexLabel).partition().make();
                    }
                    else {
                        VertexLabel label = mgmt.makeVertexLabel(vertexLabel).make();
                    }

                    LOGGER.info("makeVertexLabel :" + vertexLabel + "is ok");
                }

                mgmt.commit();

            }

        } else {
            LOGGER.info("makeVertexLabel :" + vertexLabel + " is exsiting ,Nothing to do");
        }
    }



    public static void makeEdgeLabel(JanusGraph jGraph, String edgeLabelLabel, String sig ,Multiplicity multi ) {

        LOGGER.info(" Enter makeVertexPropertyKeyIndex create edgeLabelLabel: " + edgeLabelLabel + "--sig:" + sig + "--multi:" + multi);

        if (jGraph != null && !edgeLabelLabel.isEmpty()) {
            JanusGraphManagement mgmt  = jGraph.openManagement();
            if (mgmt != null) {
                if (!mgmt.containsEdgeLabel(edgeLabelLabel)) {
                    if (sig != null) {
                        LOGGER.info("makeEdgeLabel :" + edgeLabelLabel + " as not existing" + "signature:" + sig + " Multiplicity:" + multi);
                        PropertyKey sigPropertyKey  = mgmt.getOrCreatePropertyKey(sig);
                        EdgeLabel edgeLabel = mgmt.makeEdgeLabel(edgeLabelLabel).multiplicity(multi).signature(sigPropertyKey).make();
                        mgmt.buildEdgeIndex(edgeLabel, "battlesByTime", Direction.BOTH, Order.decr, sigPropertyKey);
                        LOGGER.info("makeEdgeLabel :" + edgeLabelLabel + " is ok");
                    }
                    else {
                        EdgeLabel edgeLabel = mgmt.makeEdgeLabel(edgeLabelLabel).multiplicity(multi).make();
                    }
                }
                else {
                    LOGGER.info("makeEdgeLabel:" + edgeLabelLabel + " is exsiting");
                }
                mgmt.commit();
            }
        }
    }


    public static void  makePropertyKey(JanusGraph jGraph,String propertyKey,Class<?> classType,Cardinality cardinality ){
        if (jGraph != null && !propertyKey.isEmpty()) {
            JanusGraphManagement mgmt = jGraph.openManagement();
            if (mgmt != null) {
                if (!mgmt.containsPropertyKey(propertyKey)) {
                    LOGGER.info("makePropertyKey:" + propertyKey + " as not existing");
                    final PropertyKey property = mgmt.makePropertyKey(propertyKey).dataType(classType).cardinality(cardinality).make();
                    LOGGER.info("makePropertyKey:" + propertyKey +":dataType:"+ String.class+" ...is ok");
                }
                mgmt.commit();
            }
        }
    }

}
