package Model.com.haiwar.dao.tinkerpop.gremlin;

import org.apache.tinkerpop.gremlin.driver.Client;
import org.apache.tinkerpop.gremlin.driver.Cluster;
import org.apache.tinkerpop.gremlin.driver.ser.GryoMessageSerializerV1d0;
import org.apache.tinkerpop.gremlin.process.traversal.dsl.graph.GraphTraversalSource;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.structure.io.gryo.GryoMapper;
//import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyGraph;
import org.apache.tinkerpop.gremlin.structure.util.empty.EmptyGraph;
//import org.janusgraph.core.JanusGraph;
//import org.janusgraph.core.JanusGraphFactory;
//import org.janusgraph.graphdb.database.StandardJanusGraph;
//import org.janusgraph.graphdb.tinkerpop.JanusGraphIoRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * Created by wjl198435 on 6/9/2017.
 */
public class ConnectJanusGraphWithRemote {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConnectJanusGraphWithRemote.class);

    public static void main(String[] args) {

       long startTime=System.currentTimeMillis();



            Graph graph = EmptyGraph.instance();
            // JanusGraph graph = JanusGraphFactory.open("/Users/wjl198435/Downloads/Graph/janusgraph-0.1.1-hadoop2/conf/gremlin-server/janusgraph-cassandra-es-server-user.properties");

            try {
                GraphTraversalSource g = graph.traversal().withRemote("remote-graph.properties");

                //Graph JGraph=(Graph)g.getGraph();

                //g.getGraph();
                for (int i = 0; i < 500; i++) {
                  //Vertex person=g.V().has( "name", "name" + i).next();
                    LOGGER.info("test----:"+g.V().has( "name", "name" + i).valueMap(true).next()+"");
                   // person.

//                  Set<String> keys= person.keys();
//
//                    Iterator it=keys.iterator();
//                     while(it.hasNext()){
//                         LOGGER.info("-------------"+person.value(it.next()+""));
//                     }
//
//                    LOGGER.info(g.V().has( "name", "name" + i).next().values() +"");
                    //LOGGER.info(g.addV("hello", "hello", "name", "name" + i).next() + "");
                    LOGGER.info("name" + i);
                }
                g.close();
                graph.close();
            } catch (Exception e) {
                LOGGER.error(e.getMessage() + "");

            }


        long endTime=System.currentTimeMillis();
        LOGGER.info("Spend times"+(startTime-endTime)+"");

    }

}