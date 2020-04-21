package tonhi.com.hoccontextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import tonhi.com.hoccontextmenu.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addControls();
    }

    private void addControls() {
        registerForContextMenu(binding.btn1);
        registerForContextMenu(binding.btn2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_context_menu,menu);

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuMauDo:
                binding.btn1.setTextColor(Color.RED);
                break;
            case R.id.mnuMauVang:
                binding.btn1.setTextColor(Color.YELLOW);
                break;
            case R.id.mnuMauXanh:
                binding.btn1.setTextColor(Color.BLUE);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
