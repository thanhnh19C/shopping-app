package com.example.bt02;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editMasp, editTensp, editSoluong, editGiacu, editGiamoi;

    Button btnThem, btnSua, btnXoa;
    ListView lvView;
    ArrayList<String> arrSanpham;
    ArrayAdapter<String> adapterDB;
    String DB_NAME = "qlsp.db";
    private String DB_PATH = "/databases/";
    SQLiteDatabase database = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            xuLySaoChepCSDLTuAssets();
            addControls();
            addEvents();
            showAllProduct();
            lvView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi khi tạo: " + e.getMessage());
        }
    }

    private void addControls() {
        editMasp = findViewById(R.id.editMasp);
        editTensp = findViewById(R.id.editTensp);
        editSoluong = findViewById(R.id.editSoluong);
        editGiacu = findViewById(R.id.editGiacu);
        editGiamoi = findViewById(R.id.editGiamoi);
        btnSua = findViewById(R.id.btnSua);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        lvView = findViewById(R.id.lvHienThi);
        arrSanpham = new ArrayList<>();
        adapterDB = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrSanpham);
        lvView.setAdapter(adapterDB);
    }

    private void showAllProduct() {
        try {
            database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);
            Cursor cursor = database.query("sanpham", null, null, null, null, null, null);

            arrSanpham.clear();

            while (cursor.moveToNext()) {
                int ma = cursor.getInt(0);
                String ten = cursor.getString(1);
                String soluong = cursor.getString(2);
                String giaMoi = cursor.getString(3);
                String giaCu = cursor.getString(4);

                String productEntry = ma + "-" + ten + "-" + soluong + "-" + giaMoi + "-" + giaCu;
                arrSanpham.add(productEntry);

                // Log each entry for debugging
                Log.d("MainActivity", "Nhập sản phẩm: " + productEntry);
            }

            cursor.close();

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    adapterDB.notifyDataSetChanged();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi hiển thị tất cả sản phẩm: " + e.getMessage());
        }
    }

    private void addEvents() {
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNutXoa();
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNutThem();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuLyNutSua();
            }
        });
    }

    private void addContact(String Masp, String Tensp, String SoLuong, String GiaMoi, String GiaCu) {
        try {
            SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);

            ContentValues values = new ContentValues();
            values.put("Masp", Masp);
            values.put("Tensp", Tensp);
            values.put("Soluong", SoLuong);
            values.put("Giamoi", GiaMoi);
            values.put("Giacu", GiaCu);

            // Insert the values into the database
            database.insert("sanpham", null, values);

            database.close();

            // Log the inserted values
            Log.d("MainActivity", "Inserted values: Masp=" + Masp + ", Tensp=" + Tensp +
                    ", SoLuong=" + SoLuong + ", GiaMoi=" + GiaMoi + ", GiaCu=" + GiaCu);
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi khi thêm sản phẩm: " + e.getMessage());
        }
    }

    private void xuLyNutThem() {
        try {
            String Masp = editMasp.getText().toString();
            String Tensp = editTensp.getText().toString();
            String SoLuong = editSoluong.getText().toString();
            String GiaNew = editGiamoi.getText().toString();
            String GiaCu = editGiacu.getText().toString();

            if (!Masp.isEmpty() && !Tensp.isEmpty() && !SoLuong.isEmpty() && !GiaNew.isEmpty() && !GiaCu.isEmpty()) {
                addContact(Masp, Tensp, SoLuong, GiaNew, GiaCu);

                String productEntry = Masp + "-" + Tensp + "-" + SoLuong + "-" + GiaNew + "-" + GiaCu;
                arrSanpham.add(productEntry);
                adapterDB.notifyDataSetChanged();

                clearEditTexts();

                int newPosition = arrSanpham.indexOf(productEntry);
                lvView.smoothScrollToPosition(newPosition);

                Toast.makeText(MainActivity.this, "Đã thêm sản phẩm", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng nhập tất cả các chi tiết", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi xử lý nút thêm: " + e.getMessage());
        }
    }

    private void xuLyNutSua() {
        try {
            int selectedItemPosition = lvView.getCheckedItemPosition();

            if (selectedItemPosition != ListView.INVALID_POSITION) {
                String selectedContact = arrSanpham.get(selectedItemPosition);
                int contactID = Integer.parseInt(selectedContact.split("-")[0].trim());

                String Masp = editMasp.getText().toString();
                String Tensp = editTensp.getText().toString();
                String SoLuong = editSoluong.getText().toString();
                String GiaNew = editGiamoi.getText().toString();
                String GiaCu = editGiacu.getText().toString();

                updateContact(contactID, Masp, Tensp, SoLuong, GiaNew, GiaCu);

                // Update the ArrayList and refresh the ListView
                String updatedProductEntry = contactID + "-" + Masp + "-" + Tensp + "-" + SoLuong + "-" + GiaNew + "-" + GiaCu;
                arrSanpham.set(selectedItemPosition, updatedProductEntry);
                adapterDB.notifyDataSetChanged();

                clearEditTexts();

                Toast.makeText(MainActivity.this, "Đã cập nhật sản phẩm", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng chọn một sản phẩm để chỉnh sửa", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi xử lý nút sửa: " + e.getMessage());
        }
    }

    private void updateContact(int sanphamID, String Masp, String Tensp, String SoLuong, String GiaMoi, String GiaCu) {
        try {
            SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);

            ContentValues values = new ContentValues();
            values.put("Masp", Masp);
            values.put("Tensp", Tensp);
            values.put("Soluong", SoLuong);
            values.put("Giamoi", GiaMoi);
            values.put("Giacu", GiaCu);

            String whereClause = "Masp = ?";
            String[] whereArgs = {String.valueOf(sanphamID)};

            // Update the values in the database
            int rowsAffected = database.update("sanpham", values, whereClause, whereArgs);

            database.close();

            if (rowsAffected > 0) {
                Log.d("UpdateContact", "Đã cập nhật sản phẩm thành công");
            } else {
                Log.e("UpdateContact", "Lỗi cập nhật sản phẩm");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi cập nhật sản phẩm: " + e.getMessage());
        }
    }


    private void xuLyNutXoa() {
        try {
            int selectedItemPosition = lvView.getCheckedItemPosition();

            if (selectedItemPosition != ListView.INVALID_POSITION) {
                String selectedContact = arrSanpham.get(selectedItemPosition);
                int sanphamID = Integer.parseInt(selectedContact.split("-")[0].trim());

                deleteContact(sanphamID);

                arrSanpham.remove(selectedItemPosition);
                adapterDB.notifyDataSetChanged();

                lvView.clearChoices();

                Toast.makeText(MainActivity.this, "Xóa sản phẩm thành công", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng chọn một sản phẩm để xóa", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi xử lý nút xóa: " + e.getMessage());
        }
    }

    private void deleteContact(int sanphamID) {
        try {
            SQLiteDatabase database = openOrCreateDatabase(DB_NAME, MODE_PRIVATE, null);

            String whereClause = "Masp = ?";
            String[] whereArgs = {String.valueOf(sanphamID)};

            int rowsAffected = database.delete("sanpham", whereClause, whereArgs);

            database.close();

            if (rowsAffected > 0) {
                Log.d("DeleteContact", "Đã xóa sản phẩm thành công");
            } else {
                Log.e("DeleteContact", "Lỗi xóa liên hệ");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi xóa sản phẩm: " + e.getMessage());
        }
    }

    private void xuLySaoChepCSDLTuAssets() {
        try {
            File dbFile = getDatabasePath(DB_NAME);

            if (!dbFile.exists()) {
                copyDatabase();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi xử lý sao chép CSDL từ  Assets: " + e.getMessage());
        }
    }

    private void copyDatabase() {
        try {
            InputStream myInput = getAssets().open(DB_NAME);
            String outFileName = getApplicationInfo().dataDir + DB_PATH + DB_NAME;
            File f = new File(getApplicationInfo().dataDir + DB_PATH);
            if (!f.exists()) {
                f.mkdir();
            }

            OutputStream myOutput = new FileOutputStream(outFileName);

            byte[] buffer = new byte[1024];
            int len;

            while ((len = myInput.read(buffer)) > 0) {
                myOutput.write(buffer, 0, len);
            }

            myOutput.flush();
            myInput.close();
            myOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("MainActivity", "Lỗi sao chép cơ sở dữ liệu: " + e.getMessage());
        }
    }

    private void clearEditTexts() {
        editMasp.getText().clear();
        editTensp.getText().clear();
        editSoluong.getText().clear();
        editGiamoi.getText().clear();
        editGiacu.getText().clear();
    }
}