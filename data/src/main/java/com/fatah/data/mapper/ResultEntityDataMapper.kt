package com.fatah.data.mapper

import com.fatah.data.model.ResultData
import com.fatah.domain.entity.ResultsEntity
import javax.inject.Inject

class ResultEntityDataMapper @Inject constructor():Mapper<ResultsEntity, ResultData> {
    override fun from(e: ResultData): ResultsEntity {
        TODO("Not yet implemented")
    }

    override fun to(t: ResultsEntity): ResultData {
        TODO("Not yet implemented")
    }

}