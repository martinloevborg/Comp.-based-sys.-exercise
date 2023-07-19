/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.mycompany.maven_opcua;
package com.mycompany.ICPS;

import java.util.List;

import org.eclipse.milo.opcua.sdk.client.OpcUaClient;
import org.eclipse.milo.opcua.sdk.client.api.config.OpcUaClientConfigBuilder;
import org.eclipse.milo.opcua.stack.client.DiscoveryClient;
import org.eclipse.milo.opcua.stack.core.types.builtin.DataValue;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.enumerated.TimestampsToReturn;
import org.eclipse.milo.opcua.stack.core.types.structured.EndpointDescription;
import org.slf4j.Logger;

/**
 *
 * @author athil
 */
public class Read {
    public static void main(String[] args) {
            try 
            {
                List<EndpointDescription> endpoints = DiscoveryClient.getEndpoints("opc.tcp://LAPTOP-MB42FTTQ:53530/OPCUA/SimulationServer").get();

                OpcUaClientConfigBuilder cfg = new OpcUaClientConfigBuilder();
                cfg.setEndpoint(endpoints.get(0));

                OpcUaClient client = OpcUaClient.create(cfg.build());
                client.connect().get();

                NodeId nodeId = NodeId.parse("ns=3;i=1008");

                DataValue dataValue = client.readValue(0, TimestampsToReturn.Both, nodeId)
                        .get();
                System.out.println("DataValue= " + dataValue);

                Variant variant = dataValue.getValue();
                
                System.out.println("Variant= " + variant);

                double random = (double)variant.getValue();
                System.out.println("myVariable= " + random);

            }
            catch(Throwable ex)
            {
                ex.printStackTrace();
            }

    }
}
