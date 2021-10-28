package com.epam.spacex.presentation.home.model.mapper

import androidx.annotation.IdRes
import com.epam.spacex.R
import com.epam.spacex.data.common.mapper.Mapper
import com.epam.spacex.data.feature.launch.domain.model.LaunchQueryEntity
import com.epam.spacex.presentation.filter.model.FilterModel
import com.epam.spacex.util.Log
import java.util.*

class LaunchFilterInteractorMapper : Mapper<FilterModel, LaunchQueryEntity.FilterEntity> {
    override fun map(origin: FilterModel): LaunchQueryEntity.FilterEntity {

        return LaunchQueryEntity.FilterEntity(
            yearStart = convertToDate(year = origin.yearRange.value[0].toInt()),
            yearEndInclusive = convertToDate(
                year = origin.yearRange.value[1].toInt(),
                inclusive = true
            ),
            onlySuccessfulLaunch = origin.onlyLaunchesModel.value,
            sort = convertIdToSort(origin.sortModel.value)
        )
    }

    private fun convertIdToSort(@IdRes value: Int): LaunchQueryEntity.Sort {
        return when (value) {
            R.id.filter_sort_desc -> LaunchQueryEntity.Sort.LAUNCH_TIME_DESC
            R.id.filter_sort_asc -> LaunchQueryEntity.Sort.LAUNCH_TIME_ASC
            else -> {
                Log.wtf("Unknown Id to be mapped into ${LaunchQueryEntity.Sort::javaClass.name}")
                LaunchQueryEntity.Sort.LAUNCH_TIME_DESC //return default sort to prevent
            }
        }
    }

    private fun convertToDate(year: Int, inclusive: Boolean = false): Date {
        val cal = Calendar.getInstance()
        cal.clear()
        cal.set(Calendar.YEAR, if (inclusive) year.inc() else year)
        return cal.time
    }
}