package tech.linard.android.bsbtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        TextView detailTitle = (TextView) findViewById(R.id.detail_title);
        ImageView imageView = (ImageView) findViewById(R.id.detail_image);
        TextView detailOpens = (TextView) findViewById(R.id.detail_opens);
        TextView detailCloses = (TextView) findViewById(R.id.detail_closes);

        String title = intent.getStringExtra(getString(R.string.title));
        String opens = intent.getStringExtra(getString(R.string.opens));
        String closes = intent.getStringExtra(getString(R.string.closes));
        detailTitle.setText(title);
        detailOpens.setText(opens);
        detailCloses.setText(closes);

        if (title.equalsIgnoreCase(getString(R.string.catedral))) {
            imageView.setImageResource(R.drawable.catedral);
        } else if  (title.equalsIgnoreCase(getString(R.string.congresso))) {
            imageView.setImageResource(R.drawable.congresso);
        } else if (title.equalsIgnoreCase(getString(R.string.stf))) {
            imageView.setImageResource(R.drawable.stf);
        } else if (title.equalsIgnoreCase(getString(R.string.palacio_planalto))) {
            imageView.setImageResource(R.drawable.planalto);
        }

    }
}
