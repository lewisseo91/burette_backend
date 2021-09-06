package com.takeon.burette.article.service;

import com.takeon.burette.article.domain.MainPage;
import com.takeon.burette.article.dto.MainPageRequest;
import com.takeon.burette.article.dto.MainPageResponse;
import com.takeon.burette.article.repository.MainPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainPageService {
    @Autowired
    private MainPageRepository mainPageRepository;

    public MainPageResponse saveMainPage(MainPageRequest mainPageRequest) {
        MainPage mainPage = new MainPage(mainPageRequest);
        mainPageRepository.save(mainPage);

        return new MainPageResponse(mainPage);
    }
}
