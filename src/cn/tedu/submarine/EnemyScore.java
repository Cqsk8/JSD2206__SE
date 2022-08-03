package cn.tedu.submarine;
/**
 * 加分的接口 ：主要提供加分的行为 供实现类去实现加分细节！
 * */
public interface EnemyScore {

    /**
     *  返回值类型 为 int   代表就是若实现类被打倒可以提供对应的分数
     * */
    int getScore();

}
