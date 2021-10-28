package com.apipas.spacex.data.feature.launch.data.mapper

import com.apipas.spacex.data.common.mapper.Mapper
import com.apipas.spacex.data.feature.launch.data.datasource.rest.QueryRequestDto
import com.apipas.spacex.data.feature.launch.domain.model.LaunchQueryEntity
import com.apipas.spacex.util.Log
import com.apipas.spacex.util.extension.toISO8601Format

class LaunchQueryRequestMapper : Mapper<LaunchQueryEntity, QueryRequestDto> {
    override fun map(origin: LaunchQueryEntity): QueryRequestDto {
        return QueryRequestDto(
            options = QueryRequestDto.Options(
                limit = origin.limit,
                page = origin.nextPage,
                sort = convertSort(origin.filterEntity.sort),
                populate = getLaunchPopulate()
            ),
            query = mapOf(
                QUERY_KEY to mapOf(
                    QUERY_DATE_RANGE_FROM_KEY to origin.filterEntity.yearStart.toISO8601Format(),
                    QUERY_DATE_RANGE_TO_KEY to origin.filterEntity.yearEndInclusive.toISO8601Format(),
                )
            ) + if (origin.filterEntity.onlySuccessfulLaunch) mapOf(QUERY_SUCCESS to true) else mapOf()
        )
    }

    private fun getLaunchPopulate(): List<Map<String, Any>> {
        // obtain more data from rocket collection like name/imgs, BigThank for 'Populate' on MongoDB
        val rocketPath = mapOf(
            "path" to "rocket",
            "select" to mapOf(
                "name" to 1,
                "flickr_images" to 1
            )
        )
        return listOf(rocketPath)
    }

    private fun convertSort(sort: LaunchQueryEntity.Sort): Map<String, String> {
        return when (sort) {
            LaunchQueryEntity.Sort.LAUNCH_TIME_ASC -> QUERY_SORT_ASC
            LaunchQueryEntity.Sort.LAUNCH_TIME_DESC -> QUERY_SORT_DESC
            else -> {
                Log.wtf("$sort : Unknown type to be mapped into DTO ${QueryRequestDto::javaClass.name}")
                //return desc  by default
                QUERY_SORT_DESC
            }
        }
    }

    companion object {
        private const val QUERY_KEY = "date_utc"
        private const val QUERY_SUCCESS = "success"
        private val QUERY_SORT_ASC = mapOf<String, String>(QUERY_KEY to "asc") // ⬆ ascending
        private val QUERY_SORT_DESC = mapOf<String, String>(QUERY_KEY to "desc") // ⬇ descending
        private const val QUERY_DATE_RANGE_FROM_KEY = "\$gte"
        private const val QUERY_DATE_RANGE_TO_KEY = "\$lt"
    }
}