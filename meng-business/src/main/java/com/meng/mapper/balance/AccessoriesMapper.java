package com.meng.mapper.balance;

import com.meng.entity.balance.Accessories;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * 饰品信息表 Mapper 接口
 * </p>
 *
 * @author menghuanchenfeng
 * @since 2024-08-28 17:01:16
 */
@Mapper
public interface AccessoriesMapper extends BaseMapper<Accessories> {

    @Update("UPDATE accessories SET steam_id = #{steamId} WHERE market_hash_name = #{steamName}")
    void updateSteamIdBySteamName(@Param("steamId") Integer steamId, @Param("steamName") String steamName);
}
