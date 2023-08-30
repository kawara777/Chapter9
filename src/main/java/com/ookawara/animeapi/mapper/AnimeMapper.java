package com.ookawara.animeapi.mapper;

import com.ookawara.animeapi.entity.Anime;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AnimeMapper {

    @Select("SELECT * FROM anime")
    List<Anime> findAll();

    @Select("SELECT * FROM anime WHERE id = #{id}")
    Optional<Anime> findById(int id);

    @Select("SELECT * FROM anime WHERE episode <= #{episode}")
    List<Anime> findUpToEpisode(int episode);

    @Insert("insert into anime (name,episode) values (#{name},#{episode})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
     void createAnimeData(Anime createAnimeData);

    @Update("update anime set name = #{name},episode = #{episode} where id = #{id}")
    void updateAnimeData(int id, String name, int episode);

    @Delete("delete from anime where id = #{id}")
    void deleteById(int id);
}
