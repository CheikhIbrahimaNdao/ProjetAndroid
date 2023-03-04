package sn.esmt.projetandroid;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CVListActivity extends AppCompatActivity {

    private List<CV> cvList = new ArrayList<>();

    private ArrayAdapter<CV> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cvlist);

        ListView cvListView = findViewById(R.id.cv_list_view);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cvList);
        cvListView.setAdapter(adapter);

        loadCVs();
    }

    private void loadCVs() {
        String url = "http://localhost:8081/employees/all";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                url,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                CV cv = new CV();
                                cv.setNom(jsonObject.getString("nom"));
                                cv.setPrenom(jsonObject.getString("prenom"));
                                cv.setAge(jsonObject.getInt("age"));
                                cv.setAdresse(jsonObject.getString("adresse"));
                                cv.setEmail(jsonObject.getString("email"));
                                cv.setTelephone(jsonObject.getString("telephone"));
                                cv.setSpecialite(jsonObject.getString("specialite"));
                                cv.setNiveauEtude(jsonObject.getString("niveauEtude"));
                                cv.setExperienceProfessionnelle(jsonObject.getString("experienceProfessionnelle"));
                            }
                            adapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CVListActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        Volley.newRequestQueue(this).add(jsonArrayRequest);
    }
}

