package com.example.hulya.yemekhane.dummydata;

import com.example.hulya.yemekhane.viewmodel.AboutUsVM;

import java.util.ArrayList;


/**
 * Created by hulyacetin on 24.08.2017.
 */

public class DeveloperInformationData {

    public static ArrayList<AboutUsVM> developerDummyList() {

        ArrayList<AboutUsVM> listAboutUs = new ArrayList<>();

        AboutUsVM aboutUsVM = new AboutUsVM();
        aboutUsVM.setPerson_name("Hülya ÇETİN");
        aboutUsVM.setGithub("hülya github");
        aboutUsVM.setPerson_information("https://github.com/hulyacetin");
        aboutUsVM.setLinkedin("https://www.linkedin.com/in/h%C3%BClya-%C3%A7etin-794799136/");
        //  aboutUsVM.setPerson_photo(girl);

        listAboutUs.add(aboutUsVM);

        aboutUsVM = new AboutUsVM();
        aboutUsVM.setPerson_name("Musa Burak BOYRAZ");
        aboutUsVM.setPerson_information("MusaBurak info");
        aboutUsVM.setLinkedin("https://www.linkedin.com/in/musa-burak-boyraz-24a481116/?ppe=1");
        aboutUsVM.setGithub("https://github.com/mbboyraz");
        //  aboutUsVM.setPerson_photo(boy);

        listAboutUs.add(aboutUsVM);

        return listAboutUs;
    }
}
