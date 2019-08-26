package com.huang.pims.base.service;

public interface BaseMybatisService<R, ID> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    R queryById(ID id);

    /**
     * 新增数据
     *
     * @param r 实例对象
     * @return 实例对象
     */
    R insert(R r);

    /**
     * 修改数据
     *
     * @param r 实例对象
     * @return 实例对象
     */
    R update(R r);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    int deleteById(ID id);

}
