package com.takeon.burette.article.application;

import com.takeon.burette.article.dao.MainPageDao;
import com.takeon.burette.article.dto.MainPageRequest;
import com.takeon.burette.article.dto.MainPageResponse;
import org.springframework.stereotype.Service;

@Service
public class MainPageService {

    private MainPageDao mainPageDao;

    public MainPageService(MainPageDao mainPageDao) {
        this.mainPageDao = mainPageDao;
    }

    public MainPageResponse saveMainPage(MainPageRequest mainPageRequest) {
        int mainPageId = mainPageDao.save(mainPageRequest);
        return new MainPageResponse(mainPageId);
    }
}
