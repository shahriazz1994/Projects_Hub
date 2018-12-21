from rest_framework import viewsets
from rest_framework.response import Response
from api.serializers import FoodCategorySerializer, FoodDetailSerializer
from food.models import FoodCategory, FoodDetails


class FoodCategoryViewSet(viewsets.ReadOnlyModelViewSet):
    queryset = FoodCategory.objects.all()
    serializer_class = FoodCategorySerializer

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.object_list = self.filter_queryset(self.get_queryset())

    def list(self, request, *args, **kwargs):
        serializer = self.get_serializer(self.object_list, many=True)
        return Response({'foodcategory': serializer.data})


class FoodDetailViewSet(viewsets.ReadOnlyModelViewSet):
    queryset = FoodDetails.objects.all()
    serializer_class = FoodDetailSerializer

    def __init__(self, **kwargs):
        super().__init__(**kwargs)
        self.object_list = self.filter_queryset(self.get_queryset())

    def list(self, request, *args, **kwargs):
        serializer = self.get_serializer(self.object_list, many=True)
        return Response({'fooddetails': serializer.data})