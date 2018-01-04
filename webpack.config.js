const path = require('path');
const webpack = require('webpack');
const CommonsChunkPlugin = require("webpack/lib/optimize/CommonsChunkPlugin");
const ExtractTextPlugin = require("extract-text-webpack-plugin");
const webpackMerge = require('webpack-merge');
const devConfig = require('./webpack.dev.config.js');
const target = process.env.npm_lifecycle_event;

const common = {
    entry: {
        bundle: path.join(__dirname + '/src/main/js/index.js')
    },
    output: {
        path: path.join(__dirname, '/src/main/resources/static'),
        filename: '[name].js'
    },
    resolve: {
        extensions: ['.js'],
        alias: {
            'styles': __dirname + '/static/styles',
            'images': __dirname + '/static/images'
        }
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /(node_modules|bower_components)/,
                query: {
                    presets: ['env', 'react']
                }
            }
        ]
    },
    plugins: [
        new webpack.optimize.OccurrenceOrderPlugin(),
        new webpack.NoEmitOnErrorsPlugin(),
        new webpack.optimize.CommonsChunkPlugin({
            name: "commons",
            filename: "common.js",
            minChunks: Infinity
        })
    ]
}

const prodConfig = {
    plugins: [
        new webpack.optimize.UglifyJsPlugin({
            compress: {warnings: false}
        }),
        new ExtractTextPlugin("[name].css")
    ]
}

var config;
if(target === 'prod') {
    console.log('real build');
    config = webpackMerge(common, prodConfig);
} else {
    console.log('dev build');
    config = webpackMerge(common, devConfig);
}

module.exports = config;