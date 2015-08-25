package khoi_kiet.news.Misc;

import android.support.v4.app.Fragment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import khoi_kiet.news.Fragments.HomeFragment;
import khoi_kiet.news.Fragments.HotFragment;
import khoi_kiet.news.Fragments.NewspaperFragment;
import khoi_kiet.news.NewsUtilities.Rss24hAdapter;
import khoi_kiet.news.NewsUtilities.RssAdapter;
import khoi_kiet.news.NewsUtilities.RssCongAnAdapter;
import khoi_kiet.news.NewsUtilities.RssDanTriAdapter;
import khoi_kiet.news.NewsUtilities.RssDoiSongPhapLuatAdapter;
import khoi_kiet.news.NewsUtilities.RssNguoiLaoDongAdapter;
import khoi_kiet.news.NewsUtilities.RssTienPhongAdapter;
import khoi_kiet.news.NewsUtilities.RssVietNamNetAdapter;
import khoi_kiet.news.NewsUtilities.RssVnExpressAdapter;
import khoi_kiet.news.R;

/**
 * Created by hkhoi on 16/08/2015.
 */
public abstract class Constants {
    public static final String NEWSPAPER_ID = "newspaper_id";
    public static final String URL = "url";
    public static final String HOT_SQUARE_POS = "hot_square_pos";
    public static final String ITEM_LIST = "item_list";
    public static final String SUMMARY_IMAGES = "summaryImg";
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; <Android Version>; <Build Tag etc.>) AppleWebKit/<WebKit Rev> (KHTML, like Gecko) Chrome/<Chrome Rev> Mobile Safari/<WebKit Rev>";
    public static final String DESCRIPTION = "description";
    public static final String TITLE = "title";

    private static ArrayList<Fragment> fragments = null;
    private static ArrayList<Integer> thumbnailIds = null;
    private static HashMap<Integer, Integer> categoryMap;
    private static HashMap<Integer, String> linkMap;
    private static ArrayList<RssAdapter> adapterList;
    private static ArrayList<Integer> category_photo_ids;
    private static ArrayList<ArrayList<Integer>> category;

    /***************************************************************************************************
     * BEGIN: GridList of newspapers HERE!
     */
    public static ArrayList<Fragment> getFragments() {
        if (fragments == null) {
            fragments = new ArrayList<>();
            fragments.add(new HomeFragment());
            fragments.add(new HotFragment());
            fragments.add(new NewspaperFragment());
        }
        return fragments;
    }

    public static ArrayList<Integer> getThumbnailIds() {
        if (thumbnailIds == null) {
            thumbnailIds = new ArrayList<>();
            thumbnailIds.add(R.drawable.logo_vnexpress);
            thumbnailIds.add(R.drawable.logo_24h);
            thumbnailIds.add(R.drawable.logo_vietnamnet);
            thumbnailIds.add(R.drawable.logo_tienphong);
            thumbnailIds.add(R.drawable.logo_congan);
            thumbnailIds.add(R.drawable.logo_dantri);
            thumbnailIds.add(R.drawable.logo_dspl);
            thumbnailIds.add(R.drawable.logo_nld);
        }
        return thumbnailIds;
    }

    public static ArrayList<Integer> getCategoryPhotoIds() {
        if (category_photo_ids == null) {
            category_photo_ids = new ArrayList<>();
            category_photo_ids.add(R.drawable.category_business);
            category_photo_ids.add(R.drawable.category_education);
            category_photo_ids.add(R.drawable.category_entertainment);
            category_photo_ids.add(R.drawable.category_fun);
            category_photo_ids.add(R.drawable.category_health);
            category_photo_ids.add(R.drawable.category_politics);
            category_photo_ids.add(R.drawable.category_science);
            category_photo_ids.add(R.drawable.category_soccer);
            category_photo_ids.add(R.drawable.category_sport);
            category_photo_ids.add(R.drawable.category_talk);
            category_photo_ids.add(R.drawable.category_tech);
            category_photo_ids.add(R.drawable.category_travel);
            category_photo_ids.add(R.drawable.category_vehicles);
            category_photo_ids.add(R.drawable.category_world);
        }
        return category_photo_ids;
    }

    /***********************************************************************************************
     * END: GridList of newspapers HERE!
     */

    public static HashMap<Integer, Integer> getCategoryMap() {
        if (categoryMap == null) {
            categoryMap = new HashMap<>();
            categoryMap.put(0, R.array.vnexpress_categories);
            categoryMap.put(1, R.array.twentyfour_categories);
            categoryMap.put(2, R.array.vietnamnet_categories);
            categoryMap.put(3, R.array.tienphong_categories);
            categoryMap.put(4, R.array.congan_categories);
            categoryMap.put(5, R.array.dantri_categories);
            categoryMap.put(6, R.array.dspl_categories);
            categoryMap.put(7, R.array.nld_categories);
        }
        return categoryMap;
    }

    public static HashMap<Integer, String> getLinkMap() {
        if (linkMap == null) {
            linkMap = new HashMap<>();
            linkMap.put(0, Links.VNEXPRESS_HOME);
            linkMap.put(1, Links.VNEXPRESS_BREAKING_NEWS);
            linkMap.put(2, Links.VNEXPRESS_WORLD);
            linkMap.put(3, Links.VNEXPRESS_BUSINESS);
            linkMap.put(4, Links.VNEXPRESS_ENTERTAINMENT);
            linkMap.put(5, Links.VNEXPRESS_SPORT);
            linkMap.put(6, Links.VNEXPRESS_LAWS);
            linkMap.put(7, Links.VNEXPRESS_EDUCATION);
            linkMap.put(8, Links.VNEXPRESS_HEALTH);
            linkMap.put(9, Links.VNEXPRESS_FAMILY);
            linkMap.put(10, Links.VNEXPRESS_TRAVEL);
            linkMap.put(11, Links.VNEXPRESS_SCIENCE);
            linkMap.put(12, Links.VNEXPRESS_TECH);
            linkMap.put(13, Links.VNEXPRESS_VEHICLES);
            linkMap.put(14, Links.VNEXPRESS_COMMUNITY);
            linkMap.put(15, Links.VNEXPRESS_TALK);
            linkMap.put(16, Links.VNEXPRESS_FUN);


            linkMap.put(100, Links.TWENTYFOUR_SOCCER);
            linkMap.put(101, Links.TWENTYFOUR_BREAKING_NEWS);
            linkMap.put(102, Links.TWENTYFOUR_CRIMINAL);
            linkMap.put(103, Links.TWENTYFOUR_SPORT);
            linkMap.put(104, Links.TWENTYFOUR_ECONOMY);
            linkMap.put(105, Links.TWENTYFOUR_EDUCATION);
            linkMap.put(106, Links.TWENTYFOUR_MARKET);
            linkMap.put(107, Links.TWENTYFOUR_HEATH);
            linkMap.put(108, Links.TWENTYFOUR_SOCIETY);
            linkMap.put(109, Links.TWENTYFOUR_TECH);
            linkMap.put(110, Links.TWENTYFOUR_FOOD);
            linkMap.put(111, Links.TWENTYFOUR_MUSIC);
            linkMap.put(112, Links.TWENTYFOUR_MAKEUP);
            linkMap.put(113, Links.TWENTYFOUR_TRAVEL);
            linkMap.put(114, Links.TWENTYFOUR_ENTERTAINMENT);
            linkMap.put(115, Links.TWENTYFOUR_VEHICLES);
            linkMap.put(116, Links.TWENTYFOUR_FASHION);
            linkMap.put(117, Links.TWENTYFOUR_WEIRDNESS);
            linkMap.put(118, Links.TWENTYFOUR_FUN);

            linkMap.put(200, Links.VIETNAMNET_HOME);
            linkMap.put(201, Links.VIETNAMNET_BREAKING_NEWS);
            linkMap.put(202, Links.VIETNAMNET_FEATURES);
            linkMap.put(203, Links.VIETNAMNET_SOCIETY);
            linkMap.put(204, Links.VIETNAMNET_EDUCATION);
            linkMap.put(205, Links.VIETNAMNET_POLITICS);
            linkMap.put(206, Links.VIETNAMNET_VIETNAM_WEEK);
            linkMap.put(207, Links.VIETNAMNET_LIFESTYLE);
            linkMap.put(208, Links.VIETNAMNET_ECONOMY);
            linkMap.put(209, Links.VIETNAMNET_WORLD);
            linkMap.put(210, Links.VIETNAMNET_CULTURE);
            linkMap.put(211, Links.VIETNAMNET_SCIENCE);
            linkMap.put(212, Links.VIETNAMNET_TECH);
            linkMap.put(213, Links.VIETNAMNET_COMMUNITY);
            linkMap.put(214, Links.VIETNAMNET_PHOTO);

            linkMap.put(300, Links.TIENPHONG_HOME);
            linkMap.put(301, Links.TIENPHONG_BREAKING_NEWS);
            linkMap.put(302, Links.TIENPHONG_SOCIETY);
            linkMap.put(303, Links.TIENPHONG_LAWS);
            linkMap.put(304, Links.TIENPHONG_EDUCATION);
            linkMap.put(305, Links.TIENPHONG_BUSINESS);
            linkMap.put(306, Links.TIENPHONG_WORLD);
            linkMap.put(307, Links.TIENPHONG_SPORT);
            linkMap.put(308, Links.TIENPHONG_ENTERTAINMENT);
            linkMap.put(309, Links.TIENPHONG_YOUTH);
            linkMap.put(310, Links.TIENPHONG_TECH);
            linkMap.put(311, Links.TIENPHONG_MILITARY);

            linkMap.put(400, Links.CONGAN_HOME);
            linkMap.put(401, Links.CONGAN_LAWS);
            linkMap.put(402, Links.CONGAN_SPORT);
            linkMap.put(403, Links.CONGAN_BUSINESS);
            linkMap.put(404, Links.CONGAN_EDUCATION);
            linkMap.put(405, Links.CONGAN_HEALTH);
            linkMap.put(406, Links.CONGAN_SCIENCE);
            linkMap.put(407, Links.CONGAN_TECH);
            linkMap.put(408, Links.CONGAN_VEHICLES);
            linkMap.put(409, Links.CONGAN_COMMUNITY);
            linkMap.put(410, Links.CONGAN_TALK);
            linkMap.put(411, Links.CONGAN_POLITICS);
            linkMap.put(412, Links.CONGAN_WORLD);
            linkMap.put(413, Links.CONGAN_FUN);
            linkMap.put(414, Links.CONGAN_LIFESTYLE);

            linkMap.put(500, Links.DANTRI_HOME);
            linkMap.put(501, Links.DANTRI_EDUCATION);
            linkMap.put(502, Links.DANTRI_WORLD);
            linkMap.put(503, Links.DANTRI_BUSINESS);
            linkMap.put(504, Links.DANTRI_ENTERTAINMENT);
            linkMap.put(505, Links.DANTRI_SPORT);
            linkMap.put(506, Links.DANTRI_HEALTH);
            linkMap.put(507, Links.DANTRI_LIFESTYLE);
            linkMap.put(508, Links.DANTRI_TRAVEL);
            linkMap.put(509, Links.DANTRI_TECH);
            linkMap.put(510, Links.DANTRI_VEHICLES);
            linkMap.put(511, Links.DANTRI_COMMUNITY);
            linkMap.put(512, Links.DANTRI_TALK);

            linkMap.put(600, Links.DOISONGPHAPLUAT_HOME);
            linkMap.put(601, Links.DOISONGPHAPLUAT_BREAKING_NEWS);
            linkMap.put(602, Links.DOISONGPHAPLUAT_WORLD);
            linkMap.put(603, Links.DOISONGPHAPLUAT_BUSINESS);
            linkMap.put(604, Links.DOISONGPHAPLUAT_SOCCER);
            linkMap.put(605, Links.DOISONGPHAPLUAT_LAWS);
            linkMap.put(606, Links.DOISONGPHAPLUAT_EDUCATION);
            linkMap.put(607, Links.DOISONGPHAPLUAT_ENTERTAINMENT);
            linkMap.put(608, Links.DOISONGPHAPLUAT_SPORT);
            linkMap.put(609, Links.DOISONGPHAPLUAT_LIFESTYLE);
            linkMap.put(610, Links.DOISONGPHAPLUAT_HEALTH);
            linkMap.put(611, Links.DOISONGPHAPLUAT_TECH);
            linkMap.put(612, Links.DOISONGPHAPLUAT_VEHICLES);
            linkMap.put(613, Links.DOISONGPHAPLUAT_COMMUNITY);

            linkMap.put(700, Links.NGUOILAODONG_LAWS);
            linkMap.put(701, Links.NGUOILAODONG_BREAKING_NEWS);
            linkMap.put(702, Links.NGUOILAODONG_WORLD);
            linkMap.put(703, Links.NGUOILAODONG_BUSINESS);
            linkMap.put(704, Links.NGUOILAODONG_ENTERTAINMENT);
            linkMap.put(705, Links.NGUOILAODONG_SPORT);
        }
        return linkMap;
    }

    public static ArrayList<RssAdapter> getAdapterList() {
        if (adapterList == null) {
            adapterList = new ArrayList<>();

            adapterList.add(RssVnExpressAdapter.getInstance());
            adapterList.add(Rss24hAdapter.getInstance());   // Todo: add more RSS adapters here!
            adapterList.add(RssVietNamNetAdapter.getInstance());
            adapterList.add(RssTienPhongAdapter.getInstance());
            adapterList.add(RssCongAnAdapter.getInstance());
            adapterList.add(RssDanTriAdapter.getInstance());
            adapterList.add(RssDoiSongPhapLuatAdapter.getInstance());
            adapterList.add(RssNguoiLaoDongAdapter.getInstance());
        }
        return adapterList;
    }

    public static ArrayList<ArrayList<Integer>> getCategory() {
        if (category == null) {
            category = new ArrayList<>();

            ArrayList<Integer> business = new ArrayList<>();
            business.add(305);
            business.add(104);
            business.add(603);
            business.add(403);
            business.add(208);
            business.add(3);

            ArrayList<Integer> education = new ArrayList<>();
            education.add(304);
            education.add(105);
            education.add(204);
            education.add(404);
            education.add(501);
            education.add(605);

            ArrayList<Integer> entertainment = new ArrayList<>();
            entertainment.add(308);
            entertainment.add(114);
            entertainment.add(607);
            entertainment.add(504);
            entertainment.add(704);

            ArrayList<Integer> fun = new ArrayList<>();
            fun.add(118);
            fun.add(413);
            fun.add(16);

            ArrayList<Integer> health = new ArrayList<>();
            health.add(405);
            health.add(610);
            health.add(8);
            health.add(506);

            ArrayList<Integer> politics = new ArrayList<>();
            politics.add(205);
            politics.add(411);

            ArrayList<Integer> science = new ArrayList<>();
            science.add(211);
            science.add(406);
            science.add(11);

            ArrayList<Integer> soccer = new ArrayList<>();
            soccer.add(100);
            soccer.add(604);

            ArrayList<Integer> sport = new ArrayList<>();
            sport.add(402);
            sport.add(103);
            sport.add(608);
            sport.add(5);
            sport.add(505);

            ArrayList<Integer> talk = new ArrayList<>();
            talk.add(410);
            talk.add(15);
            talk.add(512);

            ArrayList<Integer> tech = new ArrayList<>();
            tech.add(212);
            tech.add(611);
            tech.add(109);
            tech.add(12);

            ArrayList<Integer> travel = new ArrayList<>();
            travel.add(403);
            travel.add(115);
            travel.add(612);
            travel.add(510);
            travel.add(13);

            ArrayList<Integer> vehicles = new ArrayList<>();
            vehicles.add(403);
            vehicles.add(115);
            vehicles.add(612);
            vehicles.add(510);
            vehicles.add(13);

            ArrayList<Integer> world = new ArrayList<>();
            world.add(209);
            world.add(412);
            world.add(306);
            world.add(502);
            world.add(602);
            world.add(2);
            world.add(702);

            category.add(business);
            category.add(education);
            category.add(entertainment);
            category.add(fun);
            category.add(health);
            category.add(politics);
            category.add(science);
            category.add(soccer);
            category.add(sport);
            category.add(talk);
            category.add(tech);
            category.add(travel);
            category.add(vehicles);
            category.add(world);
        }
        return category;
    }

    public static void initialize() {
        getFragments();
        getThumbnailIds();
        getCategoryPhotoIds();
        getCategoryMap();
        getLinkMap();
        getAdapterList();
        getCategory();
    }
}

