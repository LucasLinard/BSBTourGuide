package tech.linard.android.bsbtourguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    private int mType;
    private ListView mListView;
    private ArrayList<Location> mLocations;
    private LocationAdapter mLocationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent intent = getIntent();
        mType = intent.getIntExtra("type", 0);
        Toast.makeText(this, String.valueOf(mType), Toast.LENGTH_SHORT).show();

        switch (mType) {
            case 1:
                mLocations = createShoppings();
                break;
            case 2:
                mLocations = createFoods();
                break;
            case 3:
                mLocations = createParks();
                break;
            case 4:
                mLocations = createCivics();
                break;
        }

        mListView = (ListView) findViewById(R.id.list_view);
        mLocationAdapter = new LocationAdapter(this, mType, mLocations);
        mListView.setAdapter(mLocationAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                intent.putExtra(getString(R.string.title), mLocationAdapter.getItem(i).getTitle());
                intent.putExtra(getString(R.string.location), mLocationAdapter.getItem(i).getLocation());
                intent.putExtra(getString(R.string.opens), mLocationAdapter.getItem(i).getOpens());
                intent.putExtra(getString(R.string.closes), mLocationAdapter.getItem(i).getCloses());
                startActivity(intent);

            }
        });

    }

    private ArrayList<Location> createCivics() {
        ArrayList<Location> locationsArray = new ArrayList<>();
        String title = getString(R.string.congresso);
        String location = getString(R.string.congresso_location);
        String opens = "08:30";
        String closes = "17:30";
        locationsArray.add(new Location(title, location, opens, closes));

        title = getString(R.string.stf);
        location = getString(R.string.stf_location);
        opens = "12:00";
        closes = "19:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = getString(R.string.palacio_planalto);
        location = getString(R.string.palacio_location);
        opens = "09:00";
        closes = "18:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = getString(R.string.catedral);
        location = getString(R.string.catedral_location);
        opens = "09:00";
        closes = "19:00";
        locationsArray.add(new Location(title, location, opens, closes));

        return locationsArray;
    }

    private ArrayList<Location> createParks() {
        ArrayList<Location> locationsArray = new ArrayList<>();

        String title = "Parque Ana Lídia";
        String location = "Parque da Cidade, Srps - Brasília, DF";
        String opens = "00:00";
        String closes = "00:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Parque da Cidade";
        location = "SHCS - Brasília, DF, 73015-132";
        opens = "00:00";
        closes = "00:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Parque Bosque do Sudoeste";
        location = "St. Sudoeste - Cruzeiro / Sudoeste / Octogonal, Brasília - DF, 70297-400";
        opens = "06:00";
        closes = "22:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Parque Olhos D'Água";
        location = "Quadra 413 e 414 - Asa Norte, Brasília - DF, 70876-000";
        opens = "07:00";
        closes = "19:00";
        locationsArray.add(new Location(title, location, opens, closes));
        return locationsArray;
    }

    private ArrayList<Location> createFoods() {
        ArrayList<Location> locationsArray = new ArrayList<>();
        String title = "Faisão Dourado";
        String location = "Asa Sul 314 D 2 - Asa Sul, Brasília - DF, 70233-040";
        String opens = "12:00";
        String closes = "23:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Bar Beirute - Asa Sul";
        location = "Asa Sul Comércio Local Sul 109 BL A1 Loja 2/4 - Asa Sul, Brasília - DF, 70200-050";
        opens = "11:00";
        closes = "01:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Panificadora Belini";
        location = "SHCLS 113 Bloco D Loja 35/36 - Asa Sul, Brasília - DF, 70376-510";
        opens = "06:00";
        closes = "23:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Libanus Restaurante";
        location = "Scls 206 c 36 - Asa Sul, Brasília - DF, 70233-520";
        opens = "11:00";
        closes = "00:00";
        locationsArray.add(new Location(title, location, opens, closes));

        return locationsArray;
    }

    private ArrayList<Location> createShoppings() {
        ArrayList<Location> locationsArray = new ArrayList<>();
        String title = "Pátio Brasil Shopping";
        String location = "Setor Comercial Sul Q. 6 7 A - Asa Sul, Brasília - DF, 70307-902";
        String opens = "10:00";
        String closes = "22:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Venâncio Shopping";
        location = "SHCS 8 50/60 - Brasília, DF, 70333-900\n";
        opens = "09:00";
        closes = "19:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Shopping Conjunto Nacional";
        location = "Setor de Diversões Norte Conjunto A - Asa Norte, Brasília - DF, 70077-900";
        opens = "10:00";
        closes = "22:00";
        locationsArray.add(new Location(title, location, opens, closes));

        title = "Brasília Shopping";
        location = "Setor Comercial Norte Quadra 5 Bloco A - Asa Norte, Brasília - DF, 70715-900";
        opens = "10:00";
        closes = "22:00";
        locationsArray.add(new Location(title, location, opens, closes));

        return locationsArray;
    }
}
