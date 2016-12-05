package tech.linard.android.bsbtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mCivicButton;
    private Button mFoodButton;
    private Button mParkButton;
    private Button mShoppingButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

    }

    private void initViews() {
        mCivicButton = (Button) findViewById(R.id.btn_civic);
        mFoodButton = (Button) findViewById(R.id.btn_food);
        mParkButton = (Button) findViewById(R.id.btn_park);
        mShoppingButton = (Button) findViewById(R.id.btn_shopping);

        mCivicButton.setOnClickListener(this);
        mFoodButton.setOnClickListener(this);
        mParkButton.setOnClickListener(this);
        mShoppingButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ListActivity.class);
        switch (view.getId()) {
            case R.id.btn_civic:
                intent.putExtra(getString(R.string.type), 4);
                startActivity(intent);
                break;
            case R.id.btn_food:
                intent.putExtra(getString(R.string.type), 2);
                startActivity(intent);
                break;
            case R.id.btn_park:
                intent.putExtra(getString(R.string.type), 3);
                startActivity(intent);
                break;
            case R.id.btn_shopping:
                intent.putExtra(getString(R.string.type), 1);
                startActivity(intent);
                break;
        }
    }
}
