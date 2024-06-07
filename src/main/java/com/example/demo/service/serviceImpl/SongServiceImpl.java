package com.example.demo.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.Entity.Song;
import com.example.demo.mapper.SongMapper;
import com.example.demo.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zoey
 * \\_/__/
 * @Date: 2024/06/07/12:36
 * @Description:
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {
    @Autowired
    private SongMapper songMapper;

}
