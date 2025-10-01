package com.example.unit4_pathway3_project_my_city.ui.theme

import com.example.unit4_pathway3_project_my_city.Category
import com.example.unit4_pathway3_project_my_city.R
import com.example.unit4_pathway3_project_my_city.Recommendation

object DataSource {
    val categories = listOf(

        Category(
            title = "Danh lam thắng cảnh",
            imageRes = R.drawable.danh_lam_thang_canh,
            recommendations = listOf(
                Recommendation(
                    id = 1,
                    name = "Chùa bái đính",
                    descriptionRes = R.string.chua_bai_dinh,
                    imageRes = R.drawable.chua_bai_dinh
                ),
                Recommendation(
                    id = 2,
                    name = "Quần Thể Danh Thắng Tràng An",
                    descriptionRes = R.string.trang_an,
                    imageRes = R.drawable.trang_an
                ),
                Recommendation(
                    id = 3,
                    name = "Tam Cốc - Bích Động",
                    descriptionRes = R.string.tamcoc_bichdong,
                    imageRes = R.drawable.tamcoc_bichdong
                ),
                Recommendation(
                    id = 4,
                    name = "Cố Đô Hoa Lư",
                    descriptionRes = R.string.co_do_hoa_lu,
                    imageRes = R.drawable.co_do_hoa_lu
                ),
                Recommendation(
                    id = 5,
                    name = "Vườn Quốc Gia Cúc Phương",
                    descriptionRes = R.string.vuon_quoc_gia_cuc_phuong,
                    imageRes = R.drawable.vuon_quoc_gia_cuc_phuong
                ),
            )

        ),
        Category(
            title = "Công viên",
            imageRes = R.drawable.cong_vien,
            recommendations = listOf(
                Recommendation(
                    id = 6,
                    name = "Công Viên Văn Hóa Tràng An",
                    descriptionRes = R.string.cong_vien_van_hoa_trang_an,
                    imageRes = R.drawable.cong_vien_van_hoa_trang_an
                ),
                Recommendation(
                    id = 7,
                    name = "Công Viên Văn Hóa Thúy Sơn",
                    descriptionRes = R.string.cong_vien_van_hoa_thuy_son,
                    imageRes = R.drawable.cong_vien_van_hoa_thuy_son
                ),
                Recommendation(
                    id = 8,
                    name = "Công Viên Nước Ninh Bình",
                    descriptionRes = R.string.cong_vien_nuoc_ninh_binh,
                    imageRes = R.drawable.cong_vien_nuoc_ninh_binh
                ),
                Recommendation(
                    id = 9,
                    name = "Công Viên Khủng Long Ninh Bình",
                    descriptionRes = R.string.cong_vien_khung_long_ninh_binh,
                    imageRes = R.drawable.cong_vien_khung_long_ninh_binh
                ),
            )
        ),

        Category(
            title = "Lễ hội",
            imageRes = R.drawable.le_hoi,
            recommendations = listOf(
                Recommendation(
                    id = 10,
                    name = "Lễ Hội Chùa Bái Đính",
                    descriptionRes = R.string.le_hoi_chua_bai_dinh,
                    imageRes = R.drawable.le_hoi_chua_bai_dinh
                ),
                Recommendation(
                    id = 11,
                    name = "Lễ Hội Cố Đô Hoa Lư",
                    descriptionRes = R.string.le_hoi_co_do_hoa_lu,
                    imageRes = R.drawable.le_hoi_co_do_hoa_lu
                ),
                Recommendation(
                    id = 12,
                    name = "Lễ Hội Thái Vi",
                    descriptionRes = R.string.le_hoi_thai_vi,
                    imageRes = R.drawable.le_hoi_thai_vi
                ),
                Recommendation(
                    id = 13,
                    name = "Lễ Hội Trần Ninh",
                    descriptionRes = R.string.le_hoi_tran_ninh,
                    imageRes = R.drawable.le_hoi_tran_ninh
                ),
            )
        ),
        Category(
            title = "Chợ",
            imageRes = R.drawable.cho,
            recommendations = listOf(
                Recommendation(
                    id = 14,
                    name = "Chợ Rồng",
                    descriptionRes = R.string.cho_rong,
                    imageRes = R.drawable.cho_rong
                ),
                Recommendation(
                    id = 15,
                    name = "Chợ Nổi Tam Cốc",
                    descriptionRes = R.string.cho_noi_tam_coc,
                    imageRes = R.drawable.cho_noi_tam_coc
                ),
                Recommendation(
                    id = 16,
                    name = "Chợ Đầu Mối Ninh Bình",
                    descriptionRes = R.string.cho_dau_moi_ninh_binh,
                    imageRes = R.drawable.cho_dau_moi_ninh_binh
                ),
                Recommendation(
                    id = 17,
                    name = "Chợ Đêm Phố Cổ Hoa Lư",
                    descriptionRes = R.string.cho_dem_pho_co_hoa_lu,
                    imageRes = R.drawable.cho_dem_pho_co_hoa_lu
                ),
            )
        ),
        Category(
            title = "Nhà hàng",
            imageRes = R.drawable.nha_hang,
            recommendations = listOf(
                Recommendation(
                    id = 18,
                    name = "Đức Dê Restaurant",
                    descriptionRes = R.string.duc_de_restaurant,
                    imageRes = R.drawable.duc_de_restaurant
                ),
                Recommendation(
                    id = 19,
                    name = "Trung Tuyết Restaurant",
                    descriptionRes = R.string.trung_tuyet_restaurant,
                    imageRes = R.drawable.trung_tuyet_restaurant
                ),
                Recommendation(
                    id = 20,
                    name = "Hoang Cuisine",
                    descriptionRes = R.string.hoang_cuisine,
                    imageRes = R.drawable.hoang_cuisine
                ),
                Recommendation(
                    id = 21,
                    name = "Thang Long Restaurant",
                    descriptionRes = R.string.thang_long_restaurant,
                    imageRes = R.drawable.thang_long_restaurant
                ),
                Recommendation(
                    id = 22,
                    name = "Ninh Loan Rose Restaurant",
                    descriptionRes = R.string.ninh_loan_rose_restaurant,
                    imageRes = R.drawable.ninh_loan_rose_restaurant
                ),
            )
        ),


    )
}