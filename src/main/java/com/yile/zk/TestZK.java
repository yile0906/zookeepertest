package com.yile.zk;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.zookeeper.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class TestZK {

    private final static Logger logger = LogManager.getLogger("TestZK");

    private final static String connectString = "121.40.199.149:2181";

    private final static int sessionTimeout = 10000000;

    private ZooKeeper zkClient;

    @Before
    public void init() {
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent event) {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createNode() {
        try {
            String create = zkClient.create("/sanguo0000000000/shuguo", "caoxuqing".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            logger.info("创建结果{}", create);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
