package com.example.cryptoclean.domain.use_case.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class UseCase {
    protected var lastDisposable: Disposable? = null
    protected val compositeDisposable = CompositeDisposable()

    fun disposeLast() {
        lastDisposable?.let {
            if(it.isDisposed.not()) it.dispose()
        }
    }

    fun dispose() {
        compositeDisposable.clear()
    }
}