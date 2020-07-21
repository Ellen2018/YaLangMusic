package com.ellen.yalangmusic.bean

class DataConfig {
    companion object{

        fun getInitDataToAndroid7():MutableList<Android7KeyValue>{
            var data:MutableList<Android7KeyValue> = ArrayList()
            data.add(Android7KeyValue("Inspection due date",false,"11 Nov 2020"))
            data.add(Android7KeyValue("Road Tax Expiry Date",false,"11 Nov 2020"))
            data.add(Android7KeyValue("COE Expiry Date",false,"5 May 2021"))
            data.add(Android7KeyValue("Current paper value",true,"\$45,190"))
            data.add(Android7KeyValue("Scrap value",true,"\$36,000"))
            data.add(Android7KeyValue("Fines",true,"2 outstanding(View more)"))
            data.add(Android7KeyValue("Recalls",true,"3 found(View more)"))
            return data
        }

        fun initData1():MutableList<Android7KeyValue>{
            var data:MutableList<Android7KeyValue> = ArrayList()
            data.add(Android7KeyValue("Vehicle Scheme",false,"Normal"))
            data.add(Android7KeyValue("Registration Type",false,"P10-PassengerMotor Car"))
            data.add(Android7KeyValue("Vehicle Type",false,"Luxury Sedan"))
            data.add(Android7KeyValue("Color",false,"Black"))
            data.add(Android7KeyValue("Manufacturing Year",false,"2009"))
            data.add(Android7KeyValue("Transmission",false,"Automatic"))
            data.add(Android7KeyValue("Fuel Type",false,"Petrol"))
            data.add(Android7KeyValue("Mileage",false,"49000"))
            data.add(Android7KeyValue("Seat Type",false,"5 Seater"))
            data.add(Android7KeyValue("Engine Capacity",false,"1796 cc"))
            data.add(Android7KeyValue("Engine Number ",false,"27195631165868"))
            data.add(Android7KeyValue("Chassis Number",false,"WDB2110412B415509"))
            return data
        }

        fun initData2():MutableList<Android7KeyValue>{
            var data:MutableList<Android7KeyValue> = ArrayList()
            data.add(Android7KeyValue("RARF Eligiblity",false,"Yes"))
            data.add(Android7KeyValue("Open Market Value",true,"\$51954 "))
            data.add(Android7KeyValue("ARF",true,"\$51954 "))
            data.add(Android7KeyValue("COE Category",false,"B"))
            data.add(Android7KeyValue("COE QP",false,"Yes"))
            data.add(Android7KeyValue("COE PQP",false,"-"))
            data.add(Android7KeyValue("COE Renewed",false,"Yes"))
            data.add(Android7KeyValue("Total Rebate Amount",false,"\$37,325"))
            data.add(Android7KeyValue("Road Tax",true,"\$1217"))
            data.add(Android7KeyValue("First Reg.Date",false,"31/03/2009"))
            data.add(Android7KeyValue("Original Reg.Date ",false,"31/03/2009"))
            data.add(Android7KeyValue("Transfer Count",true,"1"))
            return data
        }


    }
}