package com.sunrise.roadrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @description: 自定义负载均衡算法
 * //按照轮训的方式 每个节点访问5次
 * @date: 2019/5/25 15:04
 * @auther: sunrise
 * @Gmail: liu575563079@gmail.com
 */
public class CustomLoadBalanceRule extends AbstractLoadBalancerRule {
    //总共被调用的次数，目前要求每台被调用5次
    private int total = 0;
    //当前提供服务的机器号
    private int currentIndex = 0;
    public Server choose(ILoadBalancer lb, Object key) {
        //ILoadBalancer哪一种负载均衡算法如果等于null的话就返回null，那么自然而然，它肯定会加载一种算法，所以它不会变成null。
        if (lb == null) {
            return null;
        }
        //现在还不知道是哪个算法来响应server
        Server server = null;
        //如果说server等于null，那么就看线程是否中断了，如果被中断的话就返回null
        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
//upList的意思就是现在活着的可以对外提供的机器，然后.get()方法通过
//int index = rand.nextInt(serverCount); 那么就是随机到几就返回第几的值
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();
//如果serverCount目前有三台，那么就不等于0，那么就是flase。
            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }
//这个的意思就是说如果serverCount有三台，那么index就得到了从下标0和1和2数组
// int index = rand.nextInt(serverCount);
// server = upList.get(index);
//当第一次total < 5的时候
//当第二次total < 5的时候
//当第五次total < 5的时候（那么第五次就不小于5），那么if(total < 5)这段里面的代码就不执行了
            if (total < 5) {
//那么第一次的server是0号机
//那么第二次的server也是0号机
                server = upList.get(currentIndex);
//第一次的总的计数次数是加一个1
//第二次的总的计数次数是再加一个1
                total++;
//当第五次total < 5的时候就走else
            } else {
//那么total等于0
                total = 0;
//而currentIndex就加一个1
                currentIndex++;
//那么1大于等于upList.size()，目前假设有三台机器，那么1就不大于等于upList.size()
//那么现在就是给0号机给1号机进行服务了，以此类推。。
//但是如果currentIndex等于下标3的时候并且>= upList.size()，但我们按照数组下标来算的话只
//有0和1和2的下标，那么当currentIndex等于下标3的时候这样就是超过第三台了，那么
//currentIndex就重新等于0。以此类推。。
                if (currentIndex >= upList.size()) {
                    currentIndex = 0;
                }
            }
//如果这个server等于null，那么线程中断一会，下一轮继续
            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */

                Thread.yield();
                continue;
            }
//如果活着好好的，那么就返回server回去
            if (server.isAlive()) {
                return (server);
            }
// Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }
//返回对应该响应服务是8001，还是8002还是8003
        return server;
    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }

}
