#
# Copyright (C) 2020 The Android Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License"); you may not
# use this file except in compliance with the License. You may obtain a copy of
# the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
# WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
# License for the specific language governing permissions and limitations under
# the License.
#
cmake_minimum_required(VERSION 2.8.12)

project(camera_core_jni)

add_subdirectory(${CMAKE_CURRENT_SOURCE_DIR}/libyuv)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/libyuv/include)

add_library(
        image_processing_util_jni
        SHARED
        image_processing_util_jni.cc)

find_library(log-lib log)
find_library(android-lib android)
find_library(jnigraphics-lib jnigraphics)
#find_package(libyuv REQUIRED)

#add_library(libyuv::yuv SHARED IMPORTED)
#set_target_properties(
#        libyuv::yuv PROPERTIES
#        IMPORTED_LOCATION ${CMAKE_CURRENT_SOURCE_DIR}/../../../build/intermediates/merged_native_libs/debug/out/lib/${CMAKE_ANDROID_ARCH_ABI}/libyuv.so)

target_link_libraries(image_processing_util_jni PRIVATE ${log-lib} ${android-lib} ${jnigraphics-lib} yuv)
