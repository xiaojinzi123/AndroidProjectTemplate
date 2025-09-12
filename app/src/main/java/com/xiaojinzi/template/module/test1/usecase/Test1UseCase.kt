package com.xiaojinzi.template.module.test1.usecase

import com.xiaojinzi.reactive.template.domain.BusinessUseCase
import com.xiaojinzi.reactive.template.domain.BusinessUseCaseImpl
import com.xiaojinzi.support.ktx.toStringItemDto
import kotlinx.coroutines.delay

interface Test1UseCase : BusinessUseCase {

    fun test()

}

class Test1UseCaseImpl : Test1UseCase, BusinessUseCaseImpl() {

    override fun test() {
        withTask {
            withLoading {
                delay(1000)
                tip(
                    content = "哈哈哈".toStringItemDto(),
                )
            }
        }
    }

}