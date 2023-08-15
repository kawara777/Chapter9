package com.ookawara.AnimeAPI;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AnimeMapper {

    @Select("SELECT * FROM anime")
    List<Anime> findAll();

    @Select("SELECT * FROM anime WHERE id = #{id}")
    Optional<Anime> findById(int id);

}
