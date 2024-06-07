package com.example.demo.Entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zoey
 * \\_/__/
 * @Date: 2024/06/07/12:22
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "song")
public class Song {
        @TableId(value = "songId",type = IdType.AUTO)
        private String songId;
        @TableField(value = "title")
        private String title;
        @TableField(value = "artist")
        private String artist;
        @TableField(value = "album")
        private String album;
        @TableField(value = "genre")
        private String genre;
        @TableField(value = "url")
        private String url;
        @TableField(value = "tags")
        private String tags;
        @TableField(value = "playCount")
        private Integer playCount;
        public Song(Song song){
                this.title=song.title;
                this.artist=song.artist;
                this.album=song.album;
                this.genre=song.genre;
                this.playCount=0;
                this.url=song.url;
                this.tags=song.tags;
        }
}
