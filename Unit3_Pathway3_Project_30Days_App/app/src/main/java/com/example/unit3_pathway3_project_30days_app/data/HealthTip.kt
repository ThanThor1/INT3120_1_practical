package com.example.unit3_pathway3_project_30days_app.data

import com.example.unit3_pathway3_project_30days_app.R


class HealthTip(
    val day: String,
    val title: String,
    val imageResourceId: Int,
    val description: String
)

val healthTips = listOf(
    HealthTip(
        day = "Ngày 1",
        title = "Uống nước ngay khi thức dậy",
        imageResourceId = R.drawable.day_1,
        description = "Bắt đầu ngày mới với 1-2 cốc nước ấm. Sau 7-8 giờ ngủ, cơ thể bị mất nước. Uống nước ngay khi thức dậy giúp kích hoạt chất trao đổi chất, đào thải độc tố qua đêm, cải thiện làn da và hỗ trợ tiêu hóa tốt hơn."
    ),
    HealthTip(
        day = "Ngày 2",
        title = "Đi bộ 10,000 bước mỗi ngày",
        imageResourceId = R.drawable.day_2,
        description = "Đặt mục tiêu 10,000 bước/ngày. Đi bộ là bài tập đơn giản nhưng hiệu quả. Nó giúp cải thiện sức khỏe tim mạch, giảm nguy cơ tiểu đường type 2, tăng cường xương khớp, và giúp kiểm soát cân nặng. 10,000 bước tương đương khoảng 8km, đốt cháy 300-400 calories."
    ),
    HealthTip(
        day = "Ngày 3",
        title = "Ngủ đủ 7-8 giờ mỗi đêm",
        imageResourceId = R.drawable.day_3,
        description = "Đi ngủ và thức dậy cùng giờ mỗi ngày. Giấc ngủ đủ giúp cơ thể phục hồi, tăng cường trí nhớ, cải thiện tâm trạng và hệ miễn dịch. Thiếu ngủ làm tăng nguy cơ béo phì, tim mạch, tiểu đường và suy giảm nhận thức."
    ),
    HealthTip(
        day = "Ngày 4",
        title = "Ăn ít nhất 5 phần rau củ/ngày",
        imageResourceId = R.drawable.day_4,
        description = "Mỗi bữa ăn nên có ít nhất 1-2 loại rau. Rau củ quả giàu vitamin, khoáng chất, chất xơ và chất chống oxi hóa. Chúng giúp giảm nguy cơ ung thư, bệnh tim mạch, béo phì và các bệnh mãn tính. Chất xơ trong rau còn giúp no lâu và cải thiện tiêu hóa."
    ),
    HealthTip(
        day = "Ngày 5",
        title = "Giảm đường tinh luyện",
        imageResourceId = R.drawable.day_5,
        description = "Hạn chế đồ uống có đường và đồ ăn ngọt. Đường tinh luyện gây tăng đường huyết đột ngột, làm tăng nguy cơ béo phì, tiểu đường, bệnh gan nhiễm mỡ và sâu răng. Nó còn gây nghiện và làm tăng viêm trong cơ thể. Thay thế bằng trái cây tươi hoặc mật ong tự nhiên."
    ),
    HealthTip(
        day = "Ngày 6",
        title = "Tập thở sâu 5 phút",
        imageResourceId = R.drawable.day_6,
        description = "Hít vào 4 giây, giữ 4 giây, thở ra 6 giây. Thở sâu kích hoạt hệ thần kinh phó giao cảm, giúp giảm stress, hạ huyết áp, cải thiện chức năng phổi và tăng lưu lượng oxy đến não. Nó còn giúp cải thiện tập trung, giảm lo âu và hỗ trợ giấc ngủ tốt hơn."
    ),
    HealthTip(
        day = "Ngày 7",
        title = "Hạn chế thời gian dùng điện thoại",
        imageResourceId = R.drawable.day_7,
        description = "Không xem điện thoại 1 giờ trước khi ngủ. Ánh sáng xanh từ màn hình ức chế melatonin - hormone giấc ngủ. Dùng điện thoại nhiều còn gây căng thẳng mắt, đau cổ vai gáy, giảm chất lượng giấc ngủ và ảnh hưởng sức khỏe tinh thần. Thay thế bằng đọc sách hoặc thiền định."
    ),
    HealthTip(
        day = "Ngày 8",
        title = "Ăn ngũ cốc nguyên hạt",
        imageResourceId = R.drawable.day_8,
        description = "Thay gạo trắng bằng gạo lứt, yến mạch. Ngũ cốc nguyên hạt giữ nguyên vỏ cám giàu chất xơ, vitamin B, khoáng chất và chất chống oxi hóa. Chúng giúp ổn định đường huyết, giảm cholesterol xấu, cải thiện tiêu hóa và giảm nguy cơ bệnh tim mạch, tiểu đường type 2."
    ),
    HealthTip(
        day = "Ngày 9",
        title = "Kéo giãn cơ mỗi sáng",
        imageResourceId = R.drawable.day_9,
        description = "Dành 10 phút kéo giãn toàn thân. Kéo giãn cải thiện độ linh hoạt, tăng lưu thông máu, giảm căng cơ và đau nhức. Nó giúp chuẩn bị cơ thể cho ngày mới, giảm nguy cơ chấn thương khi vận động và cải thiện tư thế. Kéo giãn buổi sáng còn tăng năng lượng và tinh thần."
    ),
    HealthTip(
        day = "Ngày 10",
        title = "Ăn protein mỗi bữa",
        imageResourceId = R.drawable.day_10,
        description = "Bổ sung thịt nạc, cá, trứng, đậu. Protein là thành phần xây dựng cơ bắp, hormone và enzyme. Nó giúp no lâu, duy trì khối lượng cơ, tăng cường trao đổi chất và hỗ trợ giảm cân. Ăn protein đều đặn còn giúp ổn định đường huyết và cải thiện phục hồi sau tập luyện."
    ),
    HealthTip(
        day = "Ngày 11",
        title = "Giảm muối trong khẩu phần",
        imageResourceId = R.drawable.day_11,
        description = "Nấu ăn tại nhà, ít nước mắm/muối. Ăn nhiều muối làm tăng huyết áp, gây giữ nước, tăng nguy cơ đột quỵ và bệnh thận. WHO khuyến nghị dưới 5g muối/ngày. Thay muối bằng thảo mộc, tỏi, gừng để tăng hương vị. Giảm muối giúp giảm phù nề và cải thiện sức khỏe tim mạch."
    ),
    HealthTip(
        day = "Ngày 12",
        title = "Thiền định 10 phút",
        imageResourceId = R.drawable.day_12,
        description = "Ngồi yên lặng, tập trung vào hơi thở. Thiền định giảm stress, lo âu, trầm cảm và cải thiện sự tập trung. Nó thay đổi cấu trúc não, tăng chất xám ở vùng liên quan đến học tập và trí nhớ. Thiền còn hạ huyết áp, tăng cường miễn dịch và cải thiện chất lượng cuộc sống."
    ),
    HealthTip(
        day = "Ngày 13",
        title = "Ăn cá béo 2 lần/tuần",
        imageResourceId = R.drawable.day_13,
        description = "Cá hồi, cá thu, cá trích giàu Omega-3. Omega-3 trong cá béo giảm viêm, cải thiện sức khỏe tim mạch, não bộ và mắt. Nó giảm triglyceride, hạ huyết áp, giảm nguy cơ đột quỵ và sa sút trí tuệ. Omega-3 còn hỗ trợ sức khỏe tâm thần và giảm triệu chứng trầm cảm."
    ),
    HealthTip(
        day = "Ngày 14",
        title = "Giảm caffeine sau 2 giờ chiều",
        imageResourceId = R.drawable.day_14,
        description = "Không uống cà phê/trà sau 14h. Caffeine có chu kỳ bán hủy 5-6 giờ, nghĩa là sau 6 giờ vẫn còn 50% trong cơ thể. Uống caffeine muộn làm gián đoạn giấc ngủ sâu, giảm chất lượng ngủ và gây mệt mỏi ngày hôm sau. Thay bằng trà thảo mộc hoặc nước lọc."
    ),
    HealthTip(
        day = "Ngày 15",
        title = "Rửa tay đúng cách",
        imageResourceId = R.drawable.day_15,
        description = "Rửa tay với xà phòng ít nhất 20 giây. Rửa tay là cách đơn giản nhất phòng ngừa bệnh tật. Nó loại bỏ vi khuẩn, virus gây bệnh đường tiêu hóa, hô hấp và nhiễm trùng. Rửa tay trước khi ăn, sau khi vệ sinh, tiếp xúc với bề mặt công cộng giúp giảm 50% nguy cơ mắc bệnh."
    ),
    HealthTip(
        day = "Ngày 16",
        title = "Tập squat mỗi ngày",
        imageResourceId = R.drawable.day_16,
        description = "Làm 3 hiệp x 15 lần squat. Squat là bài tập toàn thân tuyệt vời, tập trung vào chân, mông và core. Nó tăng cường cơ bắp, cải thiện thăng bằng, tăng mật độ xương và đốt cháy nhiều calories. Squat còn cải thiện tư thế, hỗ trợ hoạt động hàng ngày và giảm đau lưng."
    ),
    HealthTip(
        day = "Ngày 17",
        title = "Ăn chậm, nhai kỹ",
        imageResourceId = R.drawable.day_17,
        description = "Nhai mỗi miếng ít nhất 20-30 lần. Nhai kỹ giúp tiêu hóa tốt hơn vì enzyme trong nước bọt bắt đầu phân hủy thực phẩm. Ăn chậm giúp não nhận tín hiệu no kịp thời (sau 20 phút), tránh ăn quá nhiều. Nó còn giảm căng thẳng, tăng hấp thu dinh dưỡng và cải thiện sức khỏe răng miệng."
    ),
    HealthTip(
        day = "Ngày 18",
        title = "Bổ sung probiotic",
        imageResourceId = R.drawable.day_18,
        description = "Ăn sữa chua, kim chi, dưa chua. Probiotic là vi khuẩn có lợi cho đường ruột. Chúng cải thiện tiêu hóa, tăng cường miễn dịch (70% hệ miễn dịch ở ruột), giảm viêm và hỗ trợ sức khỏe tinh thần qua trục ruột-não. Probiotic còn giúp hấp thu dinh dưỡng tốt hơn."
    ),
    HealthTip(
        day = "Ngày 19",
        title = "Giảm stress bằng sở thích",
        imageResourceId = R.drawable.day_19,
        description = "Dành 30 phút cho hobby mỗi ngày. Sở thích giúp giảm cortisol - hormone stress, cải thiện tâm trạng và sức khỏe tinh thần. Hoạt động thú vị kích thích sản xuất dopamine và serotonin - hormone hạnh phúc. Nó còn tăng sáng tạo, cải thiện nhận thức và chất lượng cuộc sống."
    ),
    HealthTip(
        day = "Ngày 20",
        title = "Hạn chế thực phẩm chế biến sẵn",
        imageResourceId = R.drawable.day_20,
        description = "Nấu ăn tại nhà với nguyên liệu tươi. Thực phẩm chế biến sẵn chứa nhiều muối, đường, chất béo chuyển hóa, chất bảo quản và phẩm màu. Chúng làm tăng nguy cơ béo phì, ung thư, bệnh tim mạch và viêm ruột. Nấu ăn tại nhà giúp kiểm soát thành phần, dinh dưỡng và sức khỏe tốt hơn."
    ),
    HealthTip(
        day = "Ngày 21",
        title = "Tắm nắng 15 phút/ngày",
        imageResourceId = R.drawable.day_21,
        description = "Tắm nắng buổi sáng sớm (trước 10h). Ánh nắng mặt trời giúp cơ thể tổng hợp vitamin D - quan trọng cho xương, răng, miễn dịch và tâm trạng. Thiếu vitamin D liên quan đến loãng xương, trầm cảm và bệnh tự miễn. Ánh nắng sáng còn điều hòa nhịp sinh học và cải thiện giấc ngủ."
    ),
    HealthTip(
        day = "Ngày 22",
        title = "Vệ sinh răng miệng đúng cách",
        imageResourceId = R.drawable.day_22,
        description = "Đánh răng 2 lần, dùng chỉ nha khoa. Vệ sinh răng miệng ngăn sâu răng, viêm nướu và bệnh nha chu. Vi khuẩn trong miệng có thể vào máu, gây viêm và tăng nguy cơ bệnh tim mạch, đái tháo đường. Dùng chỉ nha khoa loại bỏ mảng bám giữa răng mà bàn chải không đến được."
    ),
    HealthTip(
        day = "Ngày 23",
        title = "Tập plank mỗi ngày",
        imageResourceId = R.drawable.day_23,
        description = "Giữ tư thế plank 30 giây x 3 lần. Plank tăng cường cơ core (bụng, lưng, hông), cải thiện tư thế, giảm đau lưng và tăng thăng bằng. Core mạnh hỗ trợ mọi hoạt động hàng ngày, bảo vệ cột sống và cải thiện hiệu suất thể thao. Plank còn đốt cháy calories và tăng cơ."
    ),
    HealthTip(
        day = "Ngày 24",
        title = "Uống trà xanh",
        imageResourceId = R.drawable.day_24,
        description = "Uống 2-3 cốc trà xanh mỗi ngày. Trà xanh giàu catechin - chất chống oxi hóa mạnh giúp chống ung thư, cải thiện chức năng não, tăng trao đổi chất và đốt cháy mỡ. Nó còn hạ cholesterol, giảm nguy cơ tiểu đường type 2 và bệnh tim mạch. L-theanine trong trà xanh giúp thư giãn nhưng vẫn tỉnh táo."
    ),
    HealthTip(
        day = "Ngày 25",
        title = "Giảm thời gian ngồi",
        imageResourceId = R.drawable.day_25,
        description = "Đứng dậy mỗi 30 phút, vận động nhẹ. Ngồi lâu làm chậm trao đổi chất, tăng nguy cơ béo phì, tiểu đường, bệnh tim mạch và ung thư đại trực tràng. Nó còn gây đau lưng, cổ vai gáy và giảm tuần hoàn máu. Đứng dậy thường xuyên, đi lại hoặc kéo giãn giúp cải thiện sức khỏe đáng kể."
    ),
    HealthTip(
        day = "Ngày 26",
        title = "Ăn hạt dinh dưỡng",
        imageResourceId = R.drawable.day_26,
        description = "Ăn 1 nắm hạnh nhân, óc chó mỗi ngày. Hạt dinh dưỡng giàu chất béo lành mạnh, protein, chất xơ, vitamin E và khoáng chất. Chúng giảm cholesterol xấu, cải thiện sức khỏe tim mạch, kiểm soát đường huyết và hỗ trợ giảm cân. Hạt còn tốt cho não bộ và giảm viêm."
    ),
    HealthTip(
        day = "Ngày 27",
        title = "Ghi nhật ký biết ơn",
        imageResourceId = R.drawable.day_27,
        description = "Viết 3 điều biết ơn mỗi tối. Thực hành biết ơn cải thiện hạnh phúc, giảm trầm cảm và lo âu. Nó thay đổi cách não xử lý cảm xúc, tăng serotonin và dopamine. Biết ơn còn cải thiện giấc ngủ, tăng cường miễn dịch, giảm stress và xây dựng mối quan hệ tốt hơn."
    ),
    HealthTip(
        day = "Ngày 28",
        title = "Tập cardio 30 phút",
        imageResourceId = R.drawable.day_28,
        description = "Chạy bộ, bơi lội, đạp xe 3-5 lần/tuần. Cardio tăng cường tim phổi, đốt cháy calories, giảm mỡ và cải thiện tuần hoàn máu. Nó giảm nguy cơ bệnh tim mạch, đột quỵ, tiểu đường và một số loại ung thư. Cardio còn giải phóng endorphin - hormone hạnh phúc, giảm stress và cải thiện tâm trạng."
    ),
    HealthTip(
        day = "Ngày 29",
        title = "Giới hạn rượu bia",
        imageResourceId = R.drawable.day_29,
        description = "Nam ≤2 ly/ngày, nữ ≤1 ly/ngày. Rượu bia gây tổn thương gan, tăng nguy cơ ung thư (gan, vú, đại trực tràng), bệnh tim mạch và ảnh hưởng não bộ. Nó còn gây mất ngủ, tăng cân và ảnh hưởng sức khỏe tinh thần. Hạn chế hoặc bỏ rượu bia cải thiện sức khỏe toàn diện."
    ),
    HealthTip(
        day = "Ngày 30",
        title = "Xây dựng thói quen lâu dài",
        imageResourceId = R.drawable.day_30,
        description = "Chọn 3-5 tips yêu thích để duy trì. Thay đổi bền vững đến từ thói quen nhỏ lặp lại hàng ngày. Đừng cố làm tất cả cùng lúc. Chọn những tips phù hợp nhất với lối sống, thực hiện đều đặn 21-66 ngày để thành thói quen. Sức khỏe là hành trình dài, không phải đích đến. Kiên nhẫn và tự thương yêu bản thân."
    )
)