package com.example.goodbam

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import kotlinx.android.synthetic.main.chart.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class ChartPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chart)

        setTemperatureChart()

        setHumidityChart()

        chart_btn_back.setOnClickListener {
            Toast.makeText(this,"아직 미구현",Toast.LENGTH_SHORT).show()
            var intnet = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }


    fun setTemperatureChart() {
        val xAxis = temperature_chart.xAxis // x축 가져오기

        val xLabel = ArrayList<String>()
        val cal = Calendar.getInstance()
        cal.time = Date()
        val df:DateFormat = SimpleDateFormat("MM-dd")

        for (i in 0 .. 7){

            cal.add(Calendar.DATE,-7+i)

            xLabel.add("${df.format(cal.time)}")

            cal.add(Calendar.DATE,7-i)
        }
        xAxis.valueFormatter = IndexAxisValueFormatter(xLabel)

        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM //x축 데이터의 위치를 아래로
            textSize = 10f // 텍스트 크기 지정(float 형으로 해주어야 함!
            setDrawGridLines(false) //배경 그리드 라인 셋팅
            granularity = 1f // x축 데이터 표시 간격
            axisMinimum = 0f // x축 데이터의 최소 표시값
            isGranularityEnabled = true // x축 간격을 제한하는 세분화 기능

        }
        temperature_chart.apply {
            axisRight.isEnabled = false // y축의 오른쪽 데이터 비활성화
            axisLeft.axisMaximum = 50f// y축의 왼쪽 데이터 최대값은 50으로
            legend.apply { //범례 셋팅
                textSize = 15f // 글자 크기 지정
                verticalAlignment = Legend.LegendVerticalAlignment.TOP //수직 조정 -> 위로
                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER//수평 조정 -> 가운데
                orientation = Legend.LegendOrientation.HORIZONTAL // 범례와 차트 정렬 -> 수평
                setDrawInside(false) //차트 안에 그릴 것인가?

            }
            setVisibleXRangeMaximum(7f) //x축 데이터 최대 표현 개수
            setPinchZoom(false) //확대 설정
            isDoubleTapToZoomEnabled = false //더블탭 확대 설정
            description.text = "" // 온도차트 안의 텍스트 설정
            background = resources.getDrawable(R.color.yellow) //배경색
            description.textSize = 15f // 텍스트 사이즈
            setExtraOffsets(8f, 16f, 8f, 16f)//차트 padding 설정
        }

        val min = 18.0
        val max = 40.0

        val input = Array<Float>(7,{(Math.random() * (max - min) + min).toFloat()})
        //Entry 배열 생성

        var entries: ArrayList<Entry> = ArrayList()

        //그래프 구현을 위한 LineDataSet생성

        var dataset: LineDataSet = LineDataSet(entries, "실내온도 (℃)")
        //그래프 data생성 -> 최종 입력 데이터

        dataset.setColor(ContextCompat.getColor(this, R.color.pink))
        //LineChart에서 Line Color 설정
        dataset.setCircleColor(ContextCompat.getColor(this, R.color.pink))
        // LineChart에서 Line Circle Color 설정
        dataset.setCircleHoleColor(ContextCompat.getColor(this, R.color.white))
        // LineChart에서 Line Hole Circle Colo

        var data: LineData = LineData(dataset)
        //chart.xml에 배치된 linChart에 데이터 연결

        temperature_chart.data = data
        temperature_chart.animateXY(0, 0)

        for (i in 0 until input.size) {
            data.addEntry(Entry(i.toFloat(), input[i].toFloat()), 0)
            temperature_chart.invalidate()
        }

    }


    fun setHumidityChart() {
        val xAxis = humidity_chart.xAxis // x축 가져오기

        val xLabel = ArrayList<String>()
        val cal = Calendar.getInstance()
        cal.time = Date()
        val df:DateFormat = SimpleDateFormat("MM-dd")

        for (i in 0 .. 7){

            cal.add(Calendar.DATE,-7+i)

            xLabel.add("${df.format(cal.time)}")

            cal.add(Calendar.DATE,7-i)
        }
        xAxis.valueFormatter = IndexAxisValueFormatter(xLabel)

        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM //x축 데이터의 위치를 아래로
            textSize = 10f // 텍스트 크기 지정(float 형으로 해주어야 함!
            setDrawGridLines(false) //배경 그리드 라인 셋팅
            granularity = 1f // x축 데이터 표시 간격
            axisMinimum = 0f // x축 데이터의 최소 표시값
            isGranularityEnabled = true // x축 간격을 제한하는 세분화 기능

        }
        humidity_chart.apply {
            axisRight.isEnabled = false // y축의 오른쪽 데이터 비활성화
            axisLeft.axisMaximum = 90f// y축의 왼쪽 데이터 최대값은 50으로
            axisLeft.axisMinimum = 30f// y축의 왼쪽 데이터 최대값은 50으로
            legend.apply { //범례 셋팅
                textSize = 15f // 글자 크기 지정
                verticalAlignment = Legend.LegendVerticalAlignment.TOP //수직 조정 -> 위로
                horizontalAlignment = Legend.LegendHorizontalAlignment.CENTER//수평 조정 -> 가운데
                orientation = Legend.LegendOrientation.HORIZONTAL // 범례와 차트 정렬 -> 수평
                setDrawInside(false) //차트 안에 그릴 것인가?

            }
            setVisibleXRangeMaximum(7f) //x축 데이터 최대 표현 개수
            setPinchZoom(false) //확대 설정
            isDoubleTapToZoomEnabled = false //더블탭 확대 설정
            description.text = "" // 온도차트 안의 텍스트 설정
            background = resources.getDrawable(R.color.yellow) //배경색
            description.textSize = 15f // 텍스트 사이즈
            setExtraOffsets(8f, 16f, 8f, 16f)//차트 padding 설정
        }

        val min = 30.0
        val max = 90.0

        val input = Array<Float>(7,{(Math.random() * (max - min) + min).toFloat()})
        //Entry 배열 생성

        var entries: ArrayList<Entry> = ArrayList()

        //그래프 구현을 위한 LineDataSet생성

        var dataset: LineDataSet = LineDataSet(entries, "실내습도 (%)")
        //그래프 data생성 -> 최종 입력 데이터
        dataset.setColor(ContextCompat.getColor(this, R.color.blue))
        //LineChart에서 Line Color 설정
        dataset.setCircleColor(ContextCompat.getColor(this, R.color.blue))
        // LineChart에서 Line Circle Color 설정
        dataset.setCircleHoleColor(ContextCompat.getColor(this, R.color.white))
        // LineChart에서 Line Hole Circle Colo

        var data: LineData = LineData(dataset)
        //chart.xml에 배치된 linChart에 데이터 연결
        humidity_chart.data = data

        humidity_chart.animateXY(0, 0)

        for (i in 0 until input.size) {
            data.addEntry(Entry(i.toFloat(), input[i].toFloat()), 0)
            humidity_chart.invalidate()
        }

    }





}



