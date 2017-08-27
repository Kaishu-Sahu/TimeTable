package com.iitr.kaishu.timetable;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    private Button btnSkip, btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);
        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);
        String manufacturer = android.os.Build.MANUFACTURER;

        if ("xiaomi".equalsIgnoreCase(manufacturer)||"oppo".equalsIgnoreCase(manufacturer)||"vivo".equalsIgnoreCase(manufacturer)) {

            SharedPreferences prefrestart = this.getSharedPreferences("restart", this.MODE_PRIVATE);
            int arestart = prefrestart.getInt("restart", 0);
            if(arestart==0){
            layouts = new int[]{
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3,
                R.layout.slide4,
                R.layout.slide5,
                R.layout.slide6
        };}
            else{ layouts = new int[]{
                    R.layout.slide1,
                    R.layout.slide2,
                    R.layout.slide3,
                    R.layout.slide4

            };}



        }
    else{
            SharedPreferences.Editor editor = IntroActivity.this.getSharedPreferences("restart", IntroActivity.this.MODE_PRIVATE).edit();
            editor.putInt("restart", 1);
            editor.apply();
        layouts = new int[]{
                R.layout.slide1,
                R.layout.slide2,
                R.layout.slide3,
                R.layout.slide4

        };}


        addBottomDots(0);

        viewPagerAdapter = new ViewPagerAdapter();
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        btnSkip.setVisibility(View.INVISIBLE);

        btnNext.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SharedPreferences.Editor editr = getSharedPreferences("restart", MODE_PRIVATE).edit();
                editr.putInt("restart", 1);
                editr.apply();
                return false;
            }
        });
    }
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                btnNext.setText(getString(R.string.start));
            }
            else if(getItem(0)==0){btnSkip.setVisibility(View.INVISIBLE);}
            else {

                btnNext.setText(getString(R.string.next));
                btnSkip.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.dot_inactive));
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(getResources().getColor(R.color.dot_active));
    }



    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    private void launchHomeScreen() {

        SharedPreferences pref = this.getSharedPreferences("restart", this.MODE_PRIVATE);
        int a = pref.getInt("restart", 0);
        if(a==1){
        startActivity(new Intent(this, MainActivity.class));
        finish();}
        else{
            Toast.makeText(this, "Restart Your Phone", Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Restart Your Phone", Toast.LENGTH_LONG).show();
        }







    }

    public class ViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;


        public ViewPagerAdapter() {

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

    public  void btnSkipClick(View v)
    { int current = getItem(0);
        if (current >0) {

            viewPager.setCurrentItem(current-1);
        } else {
           finish();
        }
    }

    public  void btnNextClick(View v)
    {

        int current = getItem(1);
        if(current==5&&layouts.length==6){
            viewPager.setCurrentItem(current);

            try{

                Intent intentttt = new Intent();
                String manufacturer = android.os.Build.MANUFACTURER;
                if ("xiaomi".equalsIgnoreCase(manufacturer)) {
                    intentttt.setComponent(new ComponentName("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"));
                } else if ("oppo".equalsIgnoreCase(manufacturer)) {
                    intentttt.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity"));
                } else if ("vivo".equalsIgnoreCase(manufacturer)) {
                    intentttt.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                }

                List<ResolveInfo> list = IntroActivity.this.getPackageManager().queryIntentActivities(intentttt, PackageManager.MATCH_DEFAULT_ONLY);
                if  (list.size() > 0) {
                    IntroActivity.this.startActivity(intentttt);
                }
            } catch (Exception e) {

            }







        }
        else if (current < layouts.length) {

            viewPager.setCurrentItem(current);
        } else {
            launchHomeScreen();
        }
    }

    @Override
    public void onBackPressed() {

        int current = getItem(0);
        if (current >0) {

            viewPager.setCurrentItem(current-1);
        } else {
            finish();
            super.onBackPressed();
        }
    }
}
