package com.kf.practice.craft;

import com.kf.practice.dao.NewsDao;
import com.kf.practice.domain.jianshu.News;
import org.springframework.beans.factory.annotation.Autowired;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.Date;
import java.util.Map;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/29
 */
public class NewsPipeline implements Pipeline{

    @Autowired
    private NewsDao newsDao;

    @Override
    public void process(ResultItems resultItems, Task task) {

        for(Map.Entry<String,Object> entry : resultItems.getAll().entrySet()){
            if(entry.getKey().contains("news")){
                News news =(News)entry.getValue();
                news.setAuthor("水花");
                news.setTypeId(1);
                news.setSort(1);
                news.setStatus(1);
                news.setExplicitLink(true);
                news.setCreateTime(new Date());
                news.setModifyDate(new Date());
                newsDao.save(news);

            }
        }

    }
}
