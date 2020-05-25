##redisLock
    以下写的是伪代码   主要业务是 stock-1
    ```
     @requestMapping("/reduceProduct")
        public void reduceProduct(){
         String  clientid= UUID.randomUUID();
         jedis.setnx("lockkey",clientid, TimeUnit.SECONDS,30);  //配置 过期时间是30s 以免死锁
            try {
                new Thread(()->{                                //另起一个线程 定时延长lockKey 过期时间  防止时间程序还没执行完  过期时间就到了
                    if(clientid== jedis.get("lockkey")){
                        setTimeInterval(function(){
                            jedis.expire("lockkey",TimeUnit.SECONDS,30);
                        },30/3)
                    }
                }).start();
                int stockNum=  jedis.get("stock");
                if(stockNum>0){
                    jedis.set("stock",stockNum-1);
                }
            }finally {
                if(clientid== jedis.get("lockkey")){ //主要防止程序执行时间大于30s,以免删除其他人的锁 从而导致锁失效
                    jedis.delete("lockkey");        //释放锁可以使用lua脚本来释放
                }
            }
    ```
        redis 分布式锁有一个问题，就是当分布式锁的k-v 还没传到 slave 时 master 结点就宕机了。锁就又失效了
        这时 就是zookeeper 分布式锁解决，