from django.urls import path, include
from rest_framework.routers import DefaultRouter
from api.viewsets import FoodCategoryViewSet, FoodDetailViewSet
router = DefaultRouter()
router.register('Food Category', viewset=FoodCategoryViewSet)
router.register('Food List', viewset=FoodDetailViewSet)

urlpatterns = [
    path('', include(router.urls)),
]