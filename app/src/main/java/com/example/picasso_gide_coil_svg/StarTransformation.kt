package com.example.picasso_gide_coil_svg

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import com.squareup.picasso.Transformation

// Класс - рамка в виде звезды для картинки
class StarTransformation: Transformation {
    override fun transform(source: Bitmap): Bitmap {
// Определяем шаблон обрезки...
        val path = Path()
// ...как звезда
        // Большой радиус звезды
        val radiusLarge: Float = source.height.toFloat() / 2
        // Малый радиус звезды
        val radiusSmall: Float = source.height.toFloat() / 5
        // число вершин
        val numberPoints: Int = 5
        // Начальная координата x
        val startX: Float = (source.height / 2).toFloat()
        // Начальная координата y
        val startY: Float = (source.height / 2).toFloat()
        // Изменение угла
        var deltaAlpha: Double = (Math.PI / numberPoints);
        // Угл
        var alpha: Double = -0.31
        // Текущий радиус
        var curRadius: Float = 0f

        repeat(numberPoints * 2) {
            curRadius = if (it % 2 == 0) radiusLarge else radiusSmall
            if (it == 0) {
                path.moveTo(
                    (startX + curRadius * Math.cos(alpha)).toFloat(),
                    (startY + curRadius * Math.sin(alpha)).toFloat())
            } else {
                path.lineTo(
                    (startX + curRadius * Math.cos(alpha)).toFloat(),
                    (startY + curRadius * Math.sin(alpha)).toFloat())
            }
            alpha += deltaAlpha
        }
        path.close()
// Создаём битмап, который и будет результирующим
        val answerBitMap =
            Bitmap.createBitmap(source.width, source.height,
                Bitmap.Config.ARGB_8888)
// Создаём холст для нового битмапа
        val canvas = Canvas(answerBitMap)
// Обрезаем холст по кругу (по шаблону)
        canvas.clipPath(path)
// А теперь рисуем на этом холсте исходное изображение
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        canvas.drawBitmap(source, 0f, 0f, paint)
        source.recycle()
        return answerBitMap
    }
    override fun key(): String {
        return "circle"
    }
}