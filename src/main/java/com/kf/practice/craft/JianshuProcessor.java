package com.kf.practice.craft;


import com.kf.practice.domain.jianshu.News;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

/**
 * @author tangjinhui
 * @Description：
 * @date 2018/1/29
 */
@Component
public class JianshuProcessor implements PageProcessor {

    public static final String list="http://www.jianshu.com";

    private Site site = Site.me()
            .setDomain("jianshu.com")
            .setSleepTime(100)
            .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36");

    @Override
    public void process(Page page) {
        if(page.getUrl().regex(list).match()){
            List<Selectable> list = page.getHtml().xpath("//ul[@class='article-list thumbnails']/li").nodes();
            for(Selectable s:list){
                String title = s.xpath("//div/h4/a/text()").toString();
                String link = s.xpath("//div/h4").links().toString();

                News news = new News();
                news.setTitle(title);
                news.setLink(link);
                news.setInfo(title);

               // news.setSource(new Sour);
                page.putField("news"+title,news);

            }
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public void run(){
        Spider spider = Spider.create(new JianshuProcessor());
        spider.addUrl("http://www.jianshu.com");
        spider.addPipeline(new NewsPipeline());
        spider.thread(5);
        spider.setExitWhenComplete(true);
        spider.start();
        System.out.println("====== JianshuProcessor run start ======");
    }


}
