package com.xiaojinzi.template.module.test1.view

import com.xiaojinzi.reactive.view.BaseViewModel
import com.xiaojinzi.template.module.test1.usecase.Test1UseCase
import com.xiaojinzi.template.module.test1.usecase.Test1UseCaseImpl

class Test1ViewModel(
    private val useCase: Test1UseCase = Test1UseCaseImpl(),
) : BaseViewModel(), Test1UseCase by useCase {
    override fun onCleared() {
        super.onCleared()
    }
}