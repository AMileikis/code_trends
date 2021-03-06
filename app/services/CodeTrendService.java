package services;

import java.util.List;

import exceptions.ApplicationException;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import models.InputForm;
import view_models.*;
import play.Logger;

@Singleton
public class CodeTrendService {

    CodeTrendAnalytics analyticsService;

    @Inject
    public CodeTrendService(CodeTrendAnalytics service) {
        this.analyticsService = service;
    }


    public CodeTrendViewModel getTrends(InputForm form) throws ApplicationException {
		Logger.info("CodeTrendViewModel.getTrends, search for {}, {}, {} ", form.language1, form.language2, form.language3);
	
        String [] input = new String [3];

        input[0] = form.language1;
        input[1] = form.language2;
        input[2] = form.language3;

        // create view model
        List<CodeTrendItem> items = analyticsService.getCodeTrends(input);

        // return
        return new CodeTrendViewModel(items);
	}

}
