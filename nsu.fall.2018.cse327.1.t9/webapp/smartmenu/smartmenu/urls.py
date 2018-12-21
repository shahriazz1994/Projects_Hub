from django.conf.urls.static import static
from django.contrib import admin
from django.urls import path, include
from accounts import views as user_views
from django.contrib.auth import views as user_auth_views
from smartmenu import settings
from . import views

urlpatterns = [
    path('admin/', admin.site.urls),
    path('accounts/register/', user_views.register, name='register'),
    path('accounts/login/', user_auth_views.LoginView.as_view(template_name='accounts/login.html'), name='login'),
    path('accounts/logout/', user_auth_views.LogoutView.as_view(template_name='accounts/logout.html'), name='logout'),
    path('accounts/profile/', user_views.profile, name='profile'),
    path('food/', include('food.urls')),
    path('', views.home, name='base-home'),
    # url for api home directory
    path('api/', include('api.urls')),

    #social auth
    path('', include('django.contrib.auth.urls')),
    path('oauth/', include('social_django.urls'), name="social"),
]
if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)

    # static url setup

